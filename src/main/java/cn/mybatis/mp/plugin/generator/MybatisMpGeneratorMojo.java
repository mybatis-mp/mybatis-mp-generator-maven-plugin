package cn.mybatis.mp.plugin.generator;

import cn.mybatis.mp.generator.config.GeneratorConfig;
import cn.mybatis.mp.plugin.generator.configuration.AbstractGeneratorConfigMojo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.util.function.Consumer;

/**
 * MybatisMpGeneratorMojo
 * Mybatis Mp 代码生成插件
 *
 * @author: trifolium.wang
 * @date: 2024/9/14
 */
@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES, requiresProject = false)
public class MybatisMpGeneratorMojo extends AbstractGeneratorConfigMojo {

    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject project;

    @Parameter(property = "mybatis.mp.generator.skip", defaultValue = "false")
    private boolean skip;

    /**
     * 配置文件(mpGeneratorConfig.xml)，和maven configuration中的配置一致，可以放到额外的文件，
     * 根目录为<mybatisMpGenerator></mybatisMpGenerator>
     * <p></p>
     * 如果同时配置，pom文件中的优先级大于配置文件
     */
    @Parameter(property = "mybatis.mp.generator.configurationFile",
            defaultValue = "${project.basedir}/mpGeneratorConfig.xml")
    protected File configurationFile;

    public void execute() {
        Log log = getLog();
        if (skip) {
            log.info("MyBatisMp generator is skipped.");
            return;
        }

        GeneratorConfig generatorConfig = new GeneratorConfig(dataSource.getJdbcUrl(),
                dataSource.getUsername(), dataSource.getPassword());
        setIfPresent(containerType, generatorConfig::containerType);
        setIfPresent(ignoreView, generatorConfig::ignoreView);
        setIfPresent(baseFilePath, (c) -> {
            if (isBlank(c)) {
                generatorConfig.baseFilePath(project.getBasedir().getAbsolutePath());
            }
        });
        setIfPresent(basePackage, (c) -> {
            if (isBlank(c)) {
                generatorConfig.basePackage(project.getGroupId());
            }
        });
        setIfPresent(templateRootPath, generatorConfig::templateRootPath);
        setIfPresent(swaggerVersion, generatorConfig::swaggerVersion);
        setIfPresent(author, generatorConfig::author);
        setIfPresent(fileCover, generatorConfig::fileCover);

        GeneratorConfigProvider confProvider = new GeneratorConfigProvider(this,
                configurationFile);

        // TODO 怎么方便的给设置属性
        // TODO 考虑使用反射处理属性注入
//        generatorConfig
//                .tableConfig(tc -> tc = confProvider.getTableConfig())
//                .columnConfig(cc -> cc = confProvider.getColumnConfig())
//                .entityConfig(ec -> ec = confProvider.getEntityConfig())
//                .mapperConfig(mc -> mc = confProvider.getMapperConfig())
//                .mapperXmlConfig(xc -> xc = confProvider.getMapperXmlConfig())
//                .daoConfig(dao -> dao = confProvider.getDaoConfig())
//                .daoImplConfig(daoImpl -> daoImpl = confProvider.getDaoImplConfig())
//                .serviceConfig(sc -> sc = confProvider.getServiceConfig())
//                .serviceImplConfig(scImpl -> scImpl = confProvider.getServiceImplConfig())
//                .actionConfig(ac -> ac = confProvider.getActionConfig());

        if (log.isDebugEnabled()) {
            log.debug("configuration info ：===================↓↓↓=====================");
            log.debug(ReflectionToStringBuilder.toString(this));
            log.debug(ReflectionToStringBuilder.toString(confProvider.getTableConfig()));
            log.debug(ReflectionToStringBuilder.toString(confProvider.getColumnConfig()));
            log.debug(ReflectionToStringBuilder.toString(confProvider.getEntityConfig()));
            log.debug(ReflectionToStringBuilder.toString(confProvider.getMapperConfig()));
            log.debug(ReflectionToStringBuilder.toString(confProvider.getMapperXmlConfig()));
            log.debug(ReflectionToStringBuilder.toString(confProvider.getDaoConfig()));
            log.debug(ReflectionToStringBuilder.toString(confProvider.getDaoImplConfig()));
            log.debug(ReflectionToStringBuilder.toString(confProvider.getServiceConfig()));
            log.debug(ReflectionToStringBuilder.toString(confProvider.getServiceImplConfig()));
            log.debug(ReflectionToStringBuilder.toString(confProvider.getActionConfig()));
            log.debug("configuration info ：===================↑↑↑=====================");
        }
    }

    private boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    private <T> void setIfPresent(T value, Consumer<T> consumer) {
        if (value instanceof Character || value instanceof String) {
            if (!isBlank(String.valueOf(value))) {
                consumer.accept(value);
            }
        } else if (value != null) {
            consumer.accept(value);
        }
    }
}
