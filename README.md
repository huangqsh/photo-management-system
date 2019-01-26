
# 一个简单的摄影博客项目

- 闲来无事，给自己搭个博客吧
> 一个不会做饭的程序员不是好的摄影师
----------

## 部署步骤
1. ...
2. ...
3. ...

## 业务说明
- 基础功能（defer）
  >用户管理、角色管理、权限管理、通知管理
- 业务功能
  >栏目管理、照片管理、文章管理、
- 隐藏功能
  >问题答案管理


## 项目框架及目录说明
- 主要框架为springBoot2.1,dao层采用轻量级Mybatis,为了提高开发速度整合了[通用mapper](https://github.com/abel533/Mapper)
```$xslt
<dependency>
    <groupId>tk.mybatis</groupId>
    <artifactId>mapper-spring-boot-starter</artifactId>
    <version>2.1.4</version>
</dependency>
```

- 目录文件说明
> top.huangqsh
>> business 业务代码
>>> article 文章管理
>>>>
>>> column 栏目管理
>>>>
>>> photo 照片管理
>>>>
>>> system 系统配置相关(用户、角色、菜单....)
>>>
>>core 工具类和系统级代码