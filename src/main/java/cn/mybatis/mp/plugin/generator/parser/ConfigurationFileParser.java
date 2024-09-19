package cn.mybatis.mp.plugin.generator.parser;

import cn.mybatis.mp.plugin.generator.configuration.AbstractGeneratorConfigMojo;
import cn.mybatis.mp.plugin.generator.configuration.XmlGeneratorConfig;

import java.io.File;

/**
 * @title: ConfigurationFileParser
 * @author: trifolium.wang
 * @date: 2024/9/18
 */
public class ConfigurationFileParser {

    public static AbstractGeneratorConfigMojo parseConfiguration(File configFile) {

        // TODO 解析xml
        return new XmlGeneratorConfig();
    }
}
