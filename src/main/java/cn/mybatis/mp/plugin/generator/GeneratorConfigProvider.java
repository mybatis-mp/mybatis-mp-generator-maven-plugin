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
    private final AbstractGeneratorConfigMojo xmlConfig;

    public GeneratorConfigProvider(AbstractGeneratorConfigMojo pomConfig, File configFile) {
        this.pomConfig = pomConfig;
        this.xmlConfig = ConfigurationFileParser.parseConfiguration(configFile);
    }

    public TableConfig getTableConfig() {
        if (xmlConfig.getTableConfig() != null) {
            return xmlConfig.getTableConfig();
        }
        return pomConfig.getTableConfig();
    }

    public ColumnConfig getColumnConfig() {
        return null;
    }

    public EntityConfig getEntityConfig() {
        return null;
    }

    public MapperConfig getMapperConfig() {
        return null;
    }

    public MapperXmlConfig getMapperXmlConfig() {
        return null;
    }

    public DaoConfig getDaoConfig() {
        return null;
    }

    public DaoImplConfig getDaoImplConfig() {
        return null;
    }

    public ServiceConfig getServiceConfig() {
        return null;
    }

    public ServiceImplConfig getServiceImplConfig() {
        return null;
    }

    public ActionConfig getActionConfig() {
        return null;
    }
}
