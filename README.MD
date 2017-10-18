---
title: 一个博客小网站的RENDME

---

# 前言

这是我在经过2周的课程设计做出来的一个小博客网站，模仿了一些博客网站系统，暂时只有登录、看自己发布的内容、看别人发布的内容、看、发布文字，图片，文章、评论、点赞等功能。里面有很多bug，不过本人也没有时间去改，里面的html样式都是本人一点一点写出来的，大神勿喷。这个网站我放出来，希望有用到的同学可以拿出来改善并使用，也希望大家一起学习交流。

# 使用的技术
网站采用java框架SpringMvc+mybatis+maven编写，jdk使用的1.7，编写工具用的myeclipse，数据库使用的mysql。

# 怎么项目在自己电脑上跑起来
大家把项目clone到自己电脑上后，用myeclipse打开，把webroot/sql里面的sql文件考到自己的mysql数据库中，打开resources/jdbc.properties,修改自己数据库连接方式。接下来就可以用tomcat发布出来登录了。预览地址[解忧杂货铺][1]


  [1]: http://xumeilin.imwork.net/module/jsp/index.jsp