# mybatis-mp-generator-maven-plugin
## 官网文档：<strong style="color:red">http://mybatis-mp.cn </strong> !!!

### mybatis-mp maven代码生成插件
### 快速开始
#### 在pom中添加插件
```xml
<plugin>
    <groupId>cn.mybatis.mp</groupId>
    <artifactId>mybatis-mp-generator-maven-plugin</artifactId>
    <version>${project.version}</version>
    <!-- 项目中需要添加驱动 -->
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.19</version>
        </dependency>
    </dependencies>
    <configuration>
        <!-- 添加数据库配置，如果项目中已经包含可省略 -->
        <dataSource>
            <username>xxx</username>
            <password>xxx</password>
            <jdbcUrl>jdbc:mysql://mysql.com:3306/db</jdbcUrl>
        </dataSource>
        <!-- 是否跳过生成,默认值false-->
        <skip>false</skip>
        <!-- 指定xml配置文件的路径,可直接使用配置文件，不用在插件的configuration中配置了 -->
        <!-- 优先级，插件configuration的配置大于文件中的配置 -->
        <configurationFile>src/main/resources/mpGeneratorConfig.xml</configurationFile>
        <!-- 其他公共参数（可在配置文件中配置的参数） -->
        <author>trifolium</author>
        <ignoreView>true</ignoreView>
        <basePackage>src/main/java/cn.mybatis.mp.plugin.test</basePackage>
        <!-- 按照官方文档配置各对象 -->
        <tableConfig>
            <tablePrefixs>
                <item>t_</item>
            </tablePrefixs>
            <includeTables>
                <item>t_admin</item>
                <item>t_admin_role</item>
            </includeTables>
        </tableConfig>
        <entityConfig>
            <packageName>entity</packageName>
            <swagger>true</swagger>
            <lombok>true</lombok>
        </entityConfig>
        <mapperConfig>
            <packageName>mapper</packageName>
            <mapperAnnotation>false</mapperAnnotation>
        </mapperConfig>
        <mapperXmlConfig>
            <enable>true</enable>
            <packageName>src/main/resources/mappers</packageName>
            <resultMap>true</resultMap>
            <columnList>true</columnList>
        </mapperXmlConfig>
        <daoConfig>
            <enable>false</enable>
        </daoConfig>
        <daoImplConfig>
            <enable>false</enable>
        </daoImplConfig>
        <serviceConfig>
            <enable>false</enable>
        </serviceConfig>
        <serviceImplConfig>
            <enable>false</enable>
        </serviceImplConfig>
        <actionConfig>
            <enable>false</enable>
        </actionConfig>
    </configuration>
</plugin>
```
### 运行maven命令 mvn  mvn mybatis-mp-generator:generate 即可

### 建议事项
* 插件中 baseFilePath 默认为maven项目根目录
* 默认configurationFile通pom.xml文件目录同级
* 默认的basePackage为maven项目的<groupId>
* 其中skip参数和configurationFile参数，必须再pom中配置，其他参数可委托到配置文件