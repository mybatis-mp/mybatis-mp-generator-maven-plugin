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
        if (pomConfig.getTableConfig() != null) {
            return pomConfig.getTableConfig();
        }
        return xmlConfig.getTableConfig();
    }

    public ColumnConfig getColumnConfig() {
        if (pomConfig.getColumnConfig() != null) {
            return pomConfig.getColumnConfig();
        }
        return xmlConfig.getColumnConfig();
    }

    public EntityConfig getEntityConfig() {
        if (pomConfig.getEntityConfig() != null) {
            return pomConfig.getEntityConfig();
        }
        return xmlConfig.getEntityConfig();
    }

    public MapperConfig getMapperConfig() {
        if (pomConfig.getMapperConfig() != null) {
            return pomConfig.getMapperConfig();
        }
        return xmlConfig.getMapperConfig();
    }

    public MapperXmlConfig getMapperXmlConfig() {
        if (pomConfig.getMapperXmlConfig() != null) {
            return pomConfig.getMapperXmlConfig();
        }
        return xmlConfig.getMapperXmlConfig();
    }

    public DaoConfig getDaoConfig() {
        if (pomConfig.getDaoConfig() != null) {
            return pomConfig.getDaoConfig();
        }
        return xmlConfig.getDaoConfig();
    }

    public DaoImplConfig getDaoImplConfig() {
        if (pomConfig.getDaoImplConfig() != null) {
            return pomConfig.getDaoImplConfig();
        }
        return xmlConfig.getDaoImplConfig();
    }

    public ServiceConfig getServiceConfig() {
        if (pomConfig.getServiceConfig() != null) {
            return pomConfig.getServiceConfig();
        }
        return xmlConfig.getServiceConfig();
    }

    public ServiceImplConfig getServiceImplConfig() {
        if (pomConfig.getServiceImplConfig() != null) {
            return pomConfig.getServiceImplConfig();
        }
        return xmlConfig.getServiceImplConfig();
    }

    public ActionConfig getActionConfig() {
        if (pomConfig.getActionConfig() != null) {
            return pomConfig.getActionConfig();
        }
        return xmlConfig.getActionConfig();
    }
}
