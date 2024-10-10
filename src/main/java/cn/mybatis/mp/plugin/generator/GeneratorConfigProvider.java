package cn.mybatis.mp.plugin.generator;

import cn.mybatis.mp.generator.config.*;
import cn.mybatis.mp.plugin.generator.configuration.AbstractGeneratorConfigMojo;
import cn.mybatis.mp.plugin.generator.parser.ConfigurationFileParser;

import java.io.File;

/**
 * @title: GeneratorConfigProvider
 * @author: trifolium.wang
 * @date: 2024/9/18
 */
public class GeneratorConfigProvider {

    private final AbstractGeneratorConfigMojo pomConfig;
    private final AbstractGeneratorConfigMojo fileConfig;

    public GeneratorConfigProvider(AbstractGeneratorConfigMojo pomConfig, File configFile) {
        this.pomConfig = pomConfig;
        this.fileConfig = ConfigurationFileParser.parseConfiguration(configFile);
    }

    public TableConfig getTableConfig() {

        return ifNullDefault(pomConfig.getTableConfig(), fileConfig.getTableConfig());
    }

    public ColumnConfig getColumnConfig() {

        return ifNullDefault(pomConfig.getColumnConfig(), fileConfig.getColumnConfig());
    }

    public EntityConfig getEntityConfig() {

        return ifNullDefault(pomConfig.getEntityConfig(), fileConfig.getEntityConfig());
    }

    public MapperConfig getMapperConfig() {

        return ifNullDefault(pomConfig.getMapperConfig(), fileConfig.getMapperConfig());
    }

    public MapperXmlConfig getMapperXmlConfig() {

        return ifNullDefault(pomConfig.getMapperXmlConfig(), fileConfig.getMapperXmlConfig());
    }

    public DaoConfig getDaoConfig() {

        return ifNullDefault(pomConfig.getDaoConfig(), fileConfig.getDaoConfig());
    }

    public DaoImplConfig getDaoImplConfig() {

        return ifNullDefault(pomConfig.getDaoImplConfig(), fileConfig.getDaoImplConfig());
    }

    public ServiceConfig getServiceConfig() {

        return ifNullDefault(pomConfig.getServiceConfig(), fileConfig.getServiceConfig());
    }

    public ServiceImplConfig getServiceImplConfig() {

        return ifNullDefault(pomConfig.getServiceImplConfig(), fileConfig.getServiceImplConfig());
    }

    public ActionConfig getActionConfig() {

        return ifNullDefault(pomConfig.getActionConfig(), fileConfig.getActionConfig());
    }

    private <T> T ifNullDefault(T t, T defaultValue) {
        return t == null ? defaultValue : t;
    }
}
