package cn.mybatis.mp.plugin.generator;

import cn.mybatis.mp.generator.FastGenerator;
import cn.mybatis.mp.generator.config.GeneratorConfig;
import cn.mybatis.mp.plugin.generator.configuration.AbstractGeneratorConfigMojo;
import cn.mybatis.mp.plugin.generator.configuration.DataSourceConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.maven.plugin.MojoExecutionException;
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

    public void execute() throws MojoExecutionException {
        Log log = getLog();
        if (skip) {
            log.info("mybatis-mp generator is skipped.");
            return;
        }

        GeneratorConfigProvider confProvider = new GeneratorConfigProvider(this,
                configurationFile);

        DataSourceConfig dataSource = confProvider.getDataSource();
        GeneratorConfig generatorConfig = new GeneratorConfig(dataSource.getJdbcUrl(),
                dataSource.getUsername(), dataSource.getPassword());

        // 填充配置
        fillGeneratorConfig(generatorConfig, confProvider);

        if (log.isDebugEnabled()) {
            log.debug("configuration info ：===================↓↓↓=====================");
            log.debug("generatorConfig: " + objToJson(this));
            log.debug("TableConfig: " + objToJson(generatorConfig.getTableConfig()));
            log.debug("ActionConfig: " + objToJson(generatorConfig.getActionConfig()));
            log.debug("ColumnConfig: " + objToJson(generatorConfig.getColumnConfig()));
            log.debug("DaoConfig: " + objToJson(generatorConfig.getDaoConfig()));
            log.debug("MapperConfig: " + objToJson(generatorConfig.getMapperConfig()));
            log.debug("EntityConfig: " + objToJson(generatorConfig.getEntityConfig()));
            log.debug("ServiceConfig: " + objToJson(generatorConfig.getServiceConfig()));
            log.debug("MapperXmlConfig: " + objToJson(generatorConfig.getMapperXmlConfig()));
            log.debug("TableConfig: " + objToJson(generatorConfig.getDaoImplConfig()));
            log.debug("ServiceImplConfig: " + objToJson(generatorConfig.getServiceImplConfig()));
            log.debug("configuration info ：===================↑↑↑=====================");
        }

        try {
            log.info("mybatis-mp-generator start");
            new FastGenerator(generatorConfig).create();
            log.info("mybatis-mp-generator success");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new MojoExecutionException(e.getMessage(), e);
        }
    }

    /**
     * 填充GeneratorConfig
     */
    private void fillGeneratorConfig(GeneratorConfig generatorConfig, GeneratorConfigProvider confProvider) {

        String baseDir = project.getBasedir().getAbsolutePath();
        // 设置直接属性默认值
        settingDefault(generatorConfig, confProvider, baseDir);

        // 设置配置属性
        ifNotNull(confProvider.getTableConfig(), generatorConfig::setTableConfig);
        ifNotNull(confProvider.getActionConfig(), generatorConfig::setActionConfig);
        ifNotNull(confProvider.getColumnConfig(), generatorConfig::setColumnConfig);
        ifNotNull(confProvider.getDaoConfig(), generatorConfig::setDaoConfig);
        ifNotNull(confProvider.getMapperConfig(), generatorConfig::setMapperConfig);
        ifNotNull(confProvider.getEntityConfig(), generatorConfig::setEntityConfig);
        ifNotNull(confProvider.getServiceConfig(), generatorConfig::setServiceConfig);
        ifNotNull(confProvider.getMapperXmlConfig(), generatorConfig::setMapperXmlConfig);
        ifNotNull(confProvider.getDaoImplConfig(), generatorConfig::setDaoImplConfig);
        ifNotNull(confProvider.getServiceImplConfig(), generatorConfig::setServiceImplConfig);
    }

    /**
     * 给GeneratorConfig设置默认值
     */
    private void settingDefault(GeneratorConfig generatorConfig, GeneratorConfigProvider confProvider, String baseDir) {
        if (isBlank(confProvider.getBaseFilePath())) {
            generatorConfig.baseFilePath(baseDir);
        } else {
            if (new File(confProvider.getBaseFilePath()).isAbsolute()) {
                generatorConfig.baseFilePath(confProvider.getBaseFilePath());
            } else {
                generatorConfig.baseFilePath(baseDir + File.separator + confProvider.getBaseFilePath());
            }
        }

        if (isBlank(confProvider.getJavaPath())) {
            generatorConfig.javaPath(project.getBuild().getSourceDirectory()
                    .replace(baseDir + File.separator, ""));
        } else {
            if (new File(confProvider.getJavaPath()).isAbsolute()) {
                generatorConfig.javaPath(confProvider.getJavaPath());
            } else {
                generatorConfig.javaPath(baseDir + File.separator + confProvider.getJavaPath());
            }
        }

        if (isBlank(confProvider.getResourcePath())) {
            generatorConfig.resourcePath("src/main/resources");
        } else {
            if (new File(confProvider.getResourcePath()).isAbsolute()) {
                generatorConfig.resourcePath(confProvider.getResourcePath());
            } else {
                generatorConfig.resourcePath(baseDir + File.separator + confProvider.getResourcePath());
            }
        }

        setIfPresent(confProvider.getContainerType(), generatorConfig::containerType);
        setIfPresent(confProvider.isIgnoreView(), generatorConfig::ignoreView);
        setIfPresent(confProvider.getBasePackage(), generatorConfig::basePackage);
        setIfPresent(confProvider.getTemplateRootPath(), generatorConfig::templateRootPath);
        setIfPresent(confProvider.getSwaggerVersion(), generatorConfig::swaggerVersion);
        setIfPresent(confProvider.getAuthor(), generatorConfig::author);
        setIfPresent(confProvider.isFileCover(), generatorConfig::fileCover);
    }

    private <T> void ifNotNull(T t, Consumer<T> consumer) {
        if (t != null) {
            consumer.accept(t);
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

    private String objToJson(Object obj) {
        if (obj == null) {
            return "";
        }
        return ReflectionToStringBuilder.toString(obj, ToStringStyle.JSON_STYLE);
    }
}
