package cn.mybatis.mp.plugin.generator.configuration;

import cn.mybatis.mp.generator.config.*;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @title: AbstractGeneratorConfigMojo
 * @author: trifolium.wang
 * @date: 2024/9/18
 */
public abstract class AbstractGeneratorConfigMojo extends AbstractMojo {

    /**
     * 数据源配置
     */
    @Parameter(name = "dataSource")
    private DataSourceConfig dataSource;

    /**
     * 容器类型，默认SPRING
     * <p>
     * 目前支持，SPRING、SOLON
     */
    @Parameter(name = "containerType", defaultValue = "SPRING")
    private ContainerType containerType;

    /**
     * 是否忽略视图
     */
    @Parameter(name = "charset", defaultValue = "utf-8")
    private String charset;

    /**
     * 是否忽略视图
     */
    @Parameter(name = "ignoreView", defaultValue = "false")
    private boolean ignoreView;

    /**
     * java源码相对baseFilePath路径，默认值 src/main/java
     */
    @Parameter(name = "javaPath")
    private String javaPath;

    /**
     * 资源目录相对baseFilePath路径, 默认值 src/main/resources
     */
    @Parameter(name = "resourcePath")
    private String resourcePath;

    /**
     * 是否忽略表
     */
    @Parameter(name = "ignoreTable", defaultValue = "false")
    private boolean ignoreTable;

    /**
     * 根文件路径
     * 默认值 project.dir(模块根目录)
     */
    @Parameter(name = "baseFilePath")
    private String baseFilePath;

    /**
     * 根包路径
     * 默认路径为""
     */
    @Parameter(name = "basePackage")
    private String basePackage;

    /**
     * 模板根目录，默认即可
     */
    @Parameter(name = "templateRootPath", defaultValue = "templates")
    private String templateRootPath;

    /**
     * 作者
     */
    @Parameter(name = "author")
    private String author;

    /**
     * swagger版本：2 代表2.x，3代表3.x
     */
    @Parameter(name = "swaggerVersion", defaultValue = "3")
    private int swaggerVersion;

    /**
     * 是否覆盖
     */
    @Parameter(name = "fileCover", defaultValue = "true")
    private boolean fileCover;

    /**
     * 配置 TableConfig(表配置)
     */
    @Parameter(name = "tableConfig")
    private TableConfig tableConfig;

    /**
     * 配置 ColumnConfig(列配置)
     */
    @Parameter(name = "columnConfig")
    private ColumnConfig columnConfig;

    /**
     * 配置 EntityConfig(实体类配置)
     */
    @Parameter(name = "entityConfig")
    private EntityConfig entityConfig;

    /**
     * 配置 MapperConfig(mapper类配置)
     */
    @Parameter(name = "mapperConfig")
    private MapperConfig mapperConfig;

    /**
     * 配置 MapperXmlConfig(mapper xml配置)
     */
    @Parameter(name = "mapperXmlConfig")
    private MapperXmlConfig mapperXmlConfig;

    /**
     * 配置 DaoConfig(dao接口配置)
     */
    @Parameter(name = "daoConfig")
    private DaoConfig daoConfig;

    /**
     * 配置 DaoImplConfig(dao接口实现类的配置)
     */
    @Parameter(name = "daoImplConfig")
    private DaoImplConfig daoImplConfig;

    /**
     * 配置 ServiceConfig(service接口配置)
     */
    @Parameter(name = "serviceConfig")
    private ServiceConfig serviceConfig;

    /**
     * 配置 ServiceImplConfig(service接口实现类的配置)
     */
    @Parameter(name = "serviceImplConfig")
    private ServiceImplConfig serviceImplConfig;

    /**
     * 配置 ActionConfig(action实现类的配置)
     */
    @Parameter(name = "actionConfig")
    private ActionConfig actionConfig;


    public TableConfig getTableConfig() {
        return tableConfig;
    }

    public void setTableConfig(TableConfig tableConfig) {
        this.tableConfig = tableConfig;
    }

    public ColumnConfig getColumnConfig() {
        return columnConfig;
    }

    public void setColumnConfig(ColumnConfig columnConfig) {
        this.columnConfig = columnConfig;
    }

    public EntityConfig getEntityConfig() {
        return entityConfig;
    }

    public void setEntityConfig(EntityConfig entityConfig) {
        this.entityConfig = entityConfig;
    }

    public MapperConfig getMapperConfig() {
        return mapperConfig;
    }

    public void setMapperConfig(MapperConfig mapperConfig) {
        this.mapperConfig = mapperConfig;
    }

    public MapperXmlConfig getMapperXmlConfig() {
        return mapperXmlConfig;
    }

    public void setMapperXmlConfig(MapperXmlConfig mapperXmlConfig) {
        this.mapperXmlConfig = mapperXmlConfig;
    }

    public DaoConfig getDaoConfig() {
        return daoConfig;
    }

    public void setDaoConfig(DaoConfig daoConfig) {
        this.daoConfig = daoConfig;
    }

    public DaoImplConfig getDaoImplConfig() {
        return daoImplConfig;
    }

    public void setDaoImplConfig(DaoImplConfig daoImplConfig) {
        this.daoImplConfig = daoImplConfig;
    }

    public ServiceConfig getServiceConfig() {
        return serviceConfig;
    }

    public void setServiceConfig(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    public ServiceImplConfig getServiceImplConfig() {
        return serviceImplConfig;
    }

    public void setServiceImplConfig(ServiceImplConfig serviceImplConfig) {
        this.serviceImplConfig = serviceImplConfig;
    }

    public ActionConfig getActionConfig() {
        return actionConfig;
    }

    public void setActionConfig(ActionConfig actionConfig) {
        this.actionConfig = actionConfig;
    }

    public String getJavaPath() {
        return javaPath;
    }

    public void setJavaPath(String javaPath) {
        this.javaPath = javaPath;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public boolean isIgnoreTable() {
        return ignoreTable;
    }

    public void setIgnoreTable(boolean ignoreTable) {
        this.ignoreTable = ignoreTable;
    }

    public DataSourceConfig getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSourceConfig dataSource) {
        this.dataSource = dataSource;
    }

    public ContainerType getContainerType() {
        return containerType;
    }

    public void setContainerType(ContainerType containerType) {
        this.containerType = containerType;
    }

    public String getBaseFilePath() {
        return baseFilePath;
    }

    public void setBaseFilePath(String baseFilePath) {
        this.baseFilePath = baseFilePath;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getTemplateRootPath() {
        return templateRootPath;
    }

    public void setTemplateRootPath(String templateRootPath) {
        this.templateRootPath = templateRootPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSwaggerVersion() {
        return swaggerVersion;
    }

    public void setSwaggerVersion(int swaggerVersion) {
        this.swaggerVersion = swaggerVersion;
    }

    public boolean isFileCover() {
        return fileCover;
    }

    public void setFileCover(boolean fileCover) {
        this.fileCover = fileCover;
    }

    public boolean isIgnoreView() {
        return ignoreView;
    }

    public void setIgnoreView(boolean ignoreView) {
        this.ignoreView = ignoreView;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
