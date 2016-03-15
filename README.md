# gmis-to-ilearn
搭建接收Restful Api管理ilearn用户的服务端

使用说明:
导入eclipse：http://www.cnblogs.com/lpshou/archive/2013/07/18/3199243.html 推荐使用方法二
修改src/main/resources中的config.properties中的数据库连接信息
使用maven插件执行package命令，将打包好的war放入tomcat目录中部署即可
建议使用环境jdk1.7,tomcat7,运行环境只需要能被gmis访问且能访问香港服务器，也可直接部署至香港服务器

功能说明：
接收四种请求，以下contextpath代表项目访问路径，如http://localhost:8080/gmis-to-ilearn
1. 查询用户
  请求链接：{contextpath}/gmis/v1/user/{userName}
  请求种类：GET
  参数：N/A
  示例：{contextpath}/gmis/v1/user/admin 即查找用户名为'admin'的用户
  返回值：json对象
    失败：{"msg":"not found"}
    成功：{"msg":"success","userId":1000,"userName":"admin","passwordHash":"1"}
2. 删除用户
  请求链接：{contextpath}/gmis/v1/user/{id}
  请求种类：DELETE
  参数：N/A
  示例：{contextpath}/gmis/v1/user/1000 即删除用户id为'1000'的用户
  返回值：json对象
    成功：{"msg":"success"}
    失败：N/A
3. 添加用户
  请求链接：{contextpath}/gmis/v1/user
  请求种类：POST
  参数：{"userName":"admin","passwordHash":"1"}
  示例：如上参数为添加用户名为admin，密码为1的用户
  返回值：json对象
    成功：{"msg":"success","userId":1000}
    失败：{“msg":"duplicated"}(用户名重复，添加失败，此处有可能出现用户删除后不能恢复的问题)
4. 更新用户
  请求链接：{contextpath}/gmis/v1/user
  请求种类：PATCH（根据原则put为全局update，patch为局部update，若不支持patch可将controller中的patch修改为put，不影响运行）
  参数：{"userId":1000,"userName":"admin","passwordHash":"1"}
  示例：如上参数为将id为1000的用户修改为用户名为admin，密码为1
  返回值：json对象
    成功：{"msg":"success"}
    失败：N/A

根据restful api的设计规则，以上所有请求可以先根据http返回码判断各种情况，返回200时表示成功，出现以上结果

日志说明
  项目中每个操作都添加了日志，目前配置地址为tomcat的log目录下的activex.log，并且每天生成一个文件

.Net中发起webapi请求的博客参考：http://www.cnblogs.com/r01cn/archive/2012/11/20/2779011.html
