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
        <!-- 按照官方文档配置各对象 -->
        <tableConfig>
            <tablePrefixs>
                <item>11111</item>
                <item>22222</item>
            </tablePrefixs>
            <includeTables>
                <item>table1</item>
                <item>table1</item>
                <item>table1</item>
            </includeTables>
        </tableConfig>
    </configuration>
</plugin>
```