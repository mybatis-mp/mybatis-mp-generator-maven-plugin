package cn.mybatis.mp.plugin.generator;

import cn.mybatis.mp.generator.config.*;
import cn.mybatis.mp.plugin.generator.configuration.AbstractGeneratorConfigMojo;
import cn.mybatis.mp.plugin.generator.configuration.DataSourceConfig;
import cn.mybatis.mp.plugin.generator.parser.ConfigurationFileParser;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;

/**
 * @title: GeneratorConfigProvider
 * @author: trifolium.wang
 * @date: 2024/9/18
 */
public class GeneratorConfigProvider {

    private final AbstractGeneratorConfigMojo pomConfig;
    private final AbstractGeneratorConfigMojo fileConfig;

    public GeneratorConfigProvider(AbstractGeneratorConfigMojo pomConfig, File configFile) throws MojoExecutionException {
        this.pomConfig = pomConfig;
        this.fileConfig = ConfigurationFileParser.parseConfiguration(configFile, pomConfig.getLog());
    }

    public DataSourceConfig getDataSource() {

        return ifNullDefault(fileConfig.getDataSource(), pomConfig.getDataSource());
    }

    public TableConfig getTableConfig() {

        return ifNullDefault(fileConfig.getTableConfig(), pomConfig.getTableConfig());
    }

    public ColumnConfig getColumnConfig() {

        return ifNullDefault(fileConfig.getColumnConfig(), pomConfig.getColumnConfig());
    }

    public EntityConfig getEntityConfig() {

        return ifNullDefault(fileConfig.getEntityConfig(), pomConfig.getEntityConfig());
    }

    public MapperConfig getMapperConfig() {

        return ifNullDefault(fileConfig.getMapperConfig(), pomConfig.getMapperConfig());
    }

    public MapperXmlConfig getMapperXmlConfig() {

        return ifNullDefault(fileConfig.getMapperXmlConfig(), pomConfig.getMapperXmlConfig());
    }

    public DaoConfig getDaoConfig() {

        return ifNullDefault(fileConfig.getDaoConfig(), pomConfig.getDaoConfig());
    }

    public DaoImplConfig getDaoImplConfig() {

        return ifNullDefault(fileConfig.getDaoImplConfig(), pomConfig.getDaoImplConfig());
    }

    public ServiceConfig getServiceConfig() {

        return ifNullDefault(fileConfig.getServiceConfig(), pomConfig.getServiceConfig());
    }

    public ServiceImplConfig getServiceImplConfig() {

        return ifNullDefault(fileConfig.getServiceImplConfig(), pomConfig.getServiceImplConfig());
    }

    public ActionConfig getActionConfig() {

        return ifNullDefault(fileConfig.getActionConfig(), pomConfig.getActionConfig());
    }

    public String getJavaPath() {
        return ifNullDefault(fileConfig.getJavaPath(), pomConfig.getJavaPath());
    }

    public String getResourcePath() {
        return ifNullDefault(fileConfig.getResourcePath(), pomConfig.getResourcePath());
    }

    public boolean isIgnoreTable() {
        return ifNullDefault(fileConfig.isIgnoreTable(), pomConfig.isIgnoreTable());
    }

    public String getCharset() {
        return ifNullDefault(fileConfig.getCharset(), pomConfig.getCharset());
    }

    public ContainerType getContainerType() {
        return ifNullDefault(fileConfig.getContainerType(), pomConfig.getContainerType());
    }

    public String getBaseFilePath() {
        return ifNullDefault(fileConfig.getBaseFilePath(), pomConfig.getBaseFilePath());
    }

    public String getBasePackage() {
        return ifNullDefault(fileConfig.getBasePackage(), pomConfig.getBasePackage());
    }

    public String getTemplateRootPath() {
        return ifNullDefault(fileConfig.getTemplateRootPath(), pomConfig.getTemplateRootPath());
    }

    public String getAuthor() {
        return ifNullDefault(fileConfig.getAuthor(), pomConfig.getAuthor());
    }

    public int getSwaggerVersion() {
        return ifNullDefault(fileConfig.getSwaggerVersion(), pomConfig.getSwaggerVersion());
    }

    public boolean isFileCover() {
        return ifNullDefault(fileConfig.isFileCover(), pomConfig.isFileCover());
    }

    public boolean isIgnoreView() {
        return ifNullDefault(fileConfig.isIgnoreView(), pomConfig.isIgnoreView());
    }

    private <T> T ifNullDefault(T t, T defaultValue) {
        return t == null ? defaultValue : t;
    }
}
