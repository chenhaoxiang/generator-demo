# generator-demo
generator的配置项目

可以设置生成扩展类。      
表字段注释在方法和属性中自动生成  
表注释在类中自动生成  


设置可以获取tables remarks信息
            设置生成类的时候可以获取表的注释信息
通过设置useInformationSchema为true可解决。
原因如下
看源码解决问题：
checkForInfoSchema && connToSet.getUseInformationSchema() && connToSet.versionMeetsMinimum(5, 0, 7) ? 
(DatabaseMetaData)Util.handleNewInstance(JDBC_4_DBMD_IS_CTOR, 
new Object[]{connToSet, databaseToSet}, connToSet.getExceptionInterceptor()) : 

(DatabaseMetaData)Util.handleNewInstance(JDBC_4_DBMD_SHOW_CTOR, 
new Object[]{connToSet, databaseToSet}, connToSet.getExceptionInterceptor());

JDBC_4_DBMD_SHOW_CTOR = Class.forName("com.mysql.jdbc.JDBC4DatabaseMetaData").getConstructor(MySQLConnection.class, String.class);
JDBC_4_DBMD_IS_CTOR = Class.forName("com.mysql.jdbc.JDBC4DatabaseMetaDataUsingInfoSchema").getConstructor(MySQLConnection.class, String.class);

都是DatabaseMetaData（数据库元数据信息）的子类

使用JDBC4DatabaseMetaData
 java.sql.ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, final String[] types)方法中
TableType枚举类型没有REMARK字段，所以说，通过getRemark获取的REMARK为空
        LOCAL_TEMPORARY("LOCAL TEMPORARY"), SYSTEM_TABLE("SYSTEM TABLE"), SYSTEM_VIEW("SYSTEM VIEW"), TABLE("TABLE", new String[] { "BASE TABLE" }),
        VIEW("VIEW"), UNKNOWN("UNKNOWN");

而使用JDBC4DatabaseMetaDataUsingInfoSchema
可以看到getTables方法中执行的是sql，有REMARK字段被查询出来
        String sql = "SELECT TABLE_SCHEMA AS TABLE_CAT, NULL AS TABLE_SCHEM, TABLE_NAME, "
                + "CASE WHEN TABLE_TYPE='BASE TABLE' THEN CASE WHEN TABLE_SCHEMA = 'mysql' OR TABLE_SCHEMA = 'performance_schema' THEN 'SYSTEM TABLE' "
                + "ELSE 'TABLE' END WHEN TABLE_TYPE='TEMPORARY' THEN 'LOCAL_TEMPORARY' ELSE TABLE_TYPE END AS TABLE_TYPE, "
                + "TABLE_COMMENT AS REMARKS, NULL AS TYPE_CAT, NULL AS TYPE_SCHEM, NULL AS TYPE_NAME, NULL AS SELF_REFERENCING_COL_NAME, "
                + "NULL AS REF_GENERATION FROM INFORMATION_SCHEMA.TABLES WHERE ";