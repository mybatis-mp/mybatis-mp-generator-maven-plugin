package cn.mybatis.mp.plugin.generator.parser;

import cn.mybatis.mp.plugin.generator.configuration.XmlGeneratorConfig;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.io.xml.XppDomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;

import java.io.File;

/**
 * @title: ConfigurationFileParser
 * @author: trifolium.wang
 * @date: 2024/9/18
 */
public class ConfigurationFileParser {

    public static XmlGeneratorConfig parseConfiguration(File configFile, Log log) throws MojoExecutionException {

        try {
            if (configFile == null) {
                return new XmlGeneratorConfig();
            }

            XStream xstream = new XStream(new PureJavaReflectionProvider(), new XppDomDriver());
            // 设置别名
            xstream.alias("mp-generator", XmlGeneratorConfig.class);
            xstream.addPermission(AnyTypePermission.ANY);
            xstream.ignoreUnknownElements();
            xstream.allowTypesByWildcard(new String[]{
                    "cn.mybatis.mp.plugin.*"
            });
            // 将 XML 转换为对象
            return (XmlGeneratorConfig) xstream.fromXML(configFile, new XmlGeneratorConfig());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new MojoExecutionException(e.getMessage(), e);
        }
    }
}
