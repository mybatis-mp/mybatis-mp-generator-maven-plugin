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
    @Parameter(name = "dataSource", required = true)
    protected DataSourceConfig dataSource;

    /**
     * 容器类型，默认SPRING
     * <p>
     * 目前支持，SPRING、SOLON
     */
    @Parameter(name = "containerType", defaultValue = "SPRING")
    protected ContainerType containerType;

    /**
     * 是否忽略视图
     */
    @Parameter(name = "ignoreView", defaultValue = "false")
    protected boolean ignoreView;

    /**
     * 是否忽略表
     */
    @Parameter(name = "ignoreTable", defaultValue = "false")
    protected boolean ignoreTable;

    /**
     * 根文件路径
     * 默认值 project.dir(模块根目录)
     */
    @Parameter(name = "baseFilePath")
    protected String baseFilePath;

    /**
     * 根包路径
     * 默认路径为 project.groupId
     */
    @Parameter(name = "basePackage")
    protected String basePackage;

    /**
     * 模板根目录，默认即可
     */
    @Parameter(name = "templateRootPath", defaultValue = "templates")
    protected String templateRootPath;

    /**
     * 作者
     */
    @Parameter(name = "author")
    protected String author;

    /**
     * swagger版本：2 代表2.x，3代表3.x
     */
    @Parameter(name = "swaggerVersion", defaultValue = "3")
    protected int swaggerVersion;

    /**
     * 是否覆盖
     */
    @Parameter(name = "fileCover", defaultValue = "true")
    protected boolean fileCover;

    /**
     * 配置 TableConfig(表配置)
     */
    @Parameter(name = "tableConfig")
    protected TableConfig tableConfig;

    /**
     * 配置 ColumnConfig(列配置)
     */
    @Parameter(name = "columnConfig")
    protected ColumnConfig columnConfig;

    /**
     * 配置 EntityConfig(实体类配置)
     */
    @Parameter(name = "entityConfig")
    protected EntityConfig entityConfig;

    /**
     * 配置 MapperConfig(mapper类配置)
     */
    @Parameter(name = "mapperConfig")
    protected MapperConfig mapperConfig;

    /**
     * 配置 MapperXmlConfig(mapper xml配置)
     */
    @Parameter(name = "mapperXmlConfig")
    protected MapperXmlConfig mapperXmlConfig;

    /**
     * 配置 DaoConfig(dao接口配置)
     */
    @Parameter(name = "daoConfig")
    protected DaoConfig daoConfig;

    /**
     * 配置 DaoImplConfig(dao接口实现类的配置)
     */
    @Parameter(name = "daoImplConfig")
    protected DaoImplConfig daoImplConfig;

    /**
     * 配置 ServiceConfig(service接口配置)
     */
    @Parameter(name = "serviceConfig")
    protected ServiceConfig serviceConfig;

    /**
     * 配置 ServiceImplConfig(service接口实现类的配置)
     */
    @Parameter(name = "serviceImplConfig")
    protected ServiceImplConfig serviceImplConfig;

    /**
     * 配置 ActionConfig(action实现类的配置)
     */
    @Parameter(name = "actionConfig")
    protected ActionConfig actionConfig;


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
}
