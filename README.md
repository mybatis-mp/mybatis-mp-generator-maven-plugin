# mybatis-mp-generator-maven-plugin
## 官网文档：<strong style="color:red">http://mybatis-mp.cn </strong> !!!

### mybatis-mp maven代码生成插件
### 快速开始
#### 在pom中添加插件
*注意除了 configurationFile和skip 配置外，其他配置参数可以放到xml文件中, xml文件root为 `<mp-generator></mp-generator>`*
```xml
<plugin>
    <groupId>cn.mybatis.mp</groupId>
    <artifactId>mybatis-mp-generator-maven-plugin</artifactId>
    <version>1.0.1</version>
    <!-- 项目中需要添加驱动 -->
    <dependencies>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.4.0</version>
        </dependency>
    </dependencies>
    <configuration>

        <!-- 指定xml配置文件的路径,可直接使用配置文件，不用在插件的configuration中配置了 -->
        <!-- 优先级， 配置文件的优先级大于 pom文件中的配置 -->
        <configurationFile>src/main/resources/mpGeneratorConfig.xml</configurationFile>
        
        <!-- 下面的配置可以统统放到xml配置文件中 -->
        <!-- xml配置文件 root为 mp-generator -->
        
        <!-- 添加数据库配置，如果项目中已经包含可省略 -->
        <dataSource>
            <username>xxx</username>
            <password>xxx</password>
            <jdbcUrl>jdbc:mysql://mysql.com:3306/db</jdbcUrl>
        </dataSource>
        <!-- 是否跳过生成,默认值false-->
        <skip>false</skip>
        <author>trifolium</author>
        <ignoreView>true</ignoreView>
<!--        <basePackage>com.xxx</basePackage>-->
        <!-- 按照官方文档配置各对象 -->
        <tableConfig>
            <tablePrefixs>
                <string>t_</string>
            </tablePrefixs>
            <includeTables>
                <string>t_admin</string>
                <string>t_admin_role</string>
            </includeTables>
        </tableConfig>
        <entityConfig>
            <packageName>com.xxx.entity</packageName>
            <swagger>true</swagger>
            <lombok>true</lombok>
        </entityConfig>
        <mapperConfig>
            <packageName>com.xxx.mapper</packageName>
            <mapperAnnotation>false</mapperAnnotation>
        </mapperConfig>
        <mapperXmlConfig>
            <enable>true</enable>
            <!-- 特殊的目录名称 -->
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
        
        <!-- 详细配置请阅读  https://mybatis-mp.cn/zh-CN/function/core/codeAutoCreate.html -->
    </configuration>
</plugin>
```

### xml文件样例
```xml
<mp-generator>
    <!-- 按照官方文档配置各对象 -->
    <author>trifolium</author>
    <fileCover>true</fileCover>
    <ignoreView>true</ignoreView>

    <dataSource>
        <username>xxx</username>
        <password>xxx</password>
        <jdbcUrl>jdbc:mysql://mysql.com:3306/db</jdbcUrl>
    </dataSource>
    
    <tableConfig>
        <tablePrefixs>
            <string>t_</string>
        </tablePrefixs>
        <includeTables>
            <string>t_admin</string>
            <string>t_admin_role</string>
        </includeTables>
    </tableConfig>

<!--    <javaPath>src/main/java</javaPath>-->
<!--    <resourcePath>src/main/resources</resourcePath>-->

    <basePackage>com.company.app.test</basePackage>

    <entityConfig>
        <packageName>entity</packageName>
        <swagger>true</swagger>
        <lombok>true</lombok>
    </entityConfig>

<!--    <basePackage>aaa</basePackage>-->
    <mapperConfig>
        <packageName>mapper</packageName>
        <mapperAnnotation>false</mapperAnnotation>
    </mapperConfig>

    <mapperXmlConfig>
        <enable>true</enable>
        <packageName>/mappers</packageName>
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
</mp-generator>
```

### 运行maven命令 `mvn mybatis-mp-generator:generate` 即可

### 建议事项
* 默认configurationFile是模块pom.xml文件目录同级下的mpGeneratorConfig.xml文件
* 插件中 baseFilePath 默认为maven项目模块根目录(project.basedir)
* 其中datasource, skip和configurationFile参数，必须在pom中配置，其他参数可委托到配置文件
* 默认javaPath 为 src/main/java (project.build.sourceDirectory)
* 默认resourcePath 为 src/main/resources