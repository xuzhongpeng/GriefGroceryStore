---
title: 基于Java语言框架SSM写的一个小博客
date: 2017-10-18 19:06:58
tags: [SSM,JAVA]
---

# 前言

这是我在经过2周的课程设计做出来的一个小博客网站，模仿了一些博客网站系统，暂时只有登录、看自己发布的内容、看别人发布的内容、看、发布文字，图片，文章、评论、点赞等功能。里面有很多bug，不过本人也没有时间去改，里面的html样式都是本人一点一点写出来的，大神勿喷。这个网站我放出来，希望有用到的同学可以拿出来改善并使用，也希望大家一起学习交流。
代码地址：[博客代码地址][1]
预览地址：[解忧杂货铺][2]
希望大家去帮我我点个star

# 使用的技术
网站采用java框架SpringMvc+mybatis+maven编写，jdk使用的1.7，编写工具用的myeclipse，数据库使用的mysql。

# 怎么项目在自己电脑上跑起来
大家把项目clone到自己电脑上后，用myeclipse打开，把webroot/sql里面的sql文件考到自己的mysql数据库中，打开resources/jdbc.properties,修改自己数据库连接方式。
![修改数据库连接][3]
接下来就可以用tomcat发布出来登录了。

# 关于图片显示的问题

我的项目里的图片路径都是image/××.jpg，我的图片是上传到tomcat上面的，这里需要用到tomcat的一个虚拟路径，现在我教大家修改虚拟路径

 1. 修改tomcat配置文件server.xml
 
 >> 向server.xml中添加一句话
 ```
 <Context path="/image" docBase="picture" debug="0" reloadable="true"/>
 ```
 ![修改tomcat配置文件server.xm][4]
 
 2. 在webapps中创建文件夹picture

![在webapps中创建文件夹picture][5]

3. 在地址栏输入localhost:8080/image/111.png就可以看到自己放在picture文件夹里面的图片了
![可以查到到图片了][6]

# 博客预览


在线预览地址：[解忧杂货铺][2]

 - 登录

![登录][7]
 
 - 首页
 
![首页][8]

- 发布文字

![发布文字][9]

- 发布图片

![发布图片][10]

- 热门消息

![热门消息][11]

- 图片展示

![图片展示][12]


  [1]: https://github.com/xuzhongpeng/GriefGroceryStore
  [2]: http://xumeilin.imwork.net/module/jsp/index.jsp
  [3]: http://www.xuzhongpeng.top/images/SSM_BLOG/20171018191514.png
  [4]: http://www.xuzhongpeng.top/images/SSM_BLOG/20171018192153.png
  [5]: http://www.xuzhongpeng.top/images/SSM_BLOG/20171018192522.png
  [6]: http://www.xuzhongpeng.top/images/SSM_BLOG/20171018193122.png
  [7]: http://www.xuzhongpeng.top/images/SSM_BLOG/20171018194236.png
  [8]: http://www.xuzhongpeng.top/images/SSM_BLOG/20171018194310.png
  [9]: http://www.xuzhongpeng.top/images/SSM_BLOG/20171018194338.png
  [10]: http://www.xuzhongpeng.top/images/SSM_BLOG/20171018194432.png
  [11]: http://www.xuzhongpeng.top/images/SSM_BLOG/20171018194502.png
  [12]: http://www.xuzhongpeng.top/images/SSM_BLOG/20171018194614.png