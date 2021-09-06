# shiro实现
## shiro是用户验证、授权、session统一管理框架，适合中小型javaweb使用
#### 优点是配置简单、轻量级别

## 开发配置步骤
1. pom里引入最新的shiro包
```java
<dependency>
    <groupId>org.apache.shiro</groupId>
    <artifactId>shiro-spring</artifactId>
    <version>1.7.1</version>
</dependency>
```
2. 三大核心组件  
2.1 Subject 提供api接口操作方法，有登录、验证等等相关操作  
2.2 ShiroFilterFactoryBean 过滤器，配置路径过滤  
2.3 AuthorizingRealm 配置用户登录验证、注入权限等操作
3. 工程项目结构  
|-src  
   -- controller 对外服务，加入登录、限制权限访问API等等例子  
   -- entity 数据库实体类  
   -- exception 过滤器对未验证数据无法进行跳转，只能抛异常捕获的方式来处理跳转  
   -- mapper 数据表结构(用户表、角色表、权限表、用户--角色关联表、角色--权限关联表)  
   -- shiro 配置shiro过滤和自定义的AuthorizingRealm