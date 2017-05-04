性格测试系统
@RequestBody
GET、POST方式提时， 根据request header Content-Type的值来判断:
    application/x-www-form-urlencoded， 可选（即非必须，因为这种情况的数据@RequestParam, @ModelAttribute也可以处理，当然@RequestBody也能处理）；
    multipart/form-data, 不能处理（次类型多用来上传文件类型---即使用@RequestBody不能处理这种格式的数据,@RequestParam这个却是可以处理的。）；
    其他格式， 必须（其他格式包括application/json, application/xml等。这些格式的数据，必须使用@RequestBody来处理）；

PUT方式提交时， 根据request header Content-Type的值来判断:(表示没见过put方式滴，可以无视吧。)
    application/x-www-form-urlencoded， 必须；
    multipart/form-data, 不能处理；
    其他格式， 必须；

说明：request的body部分的数据编码格式由header部分的Content-Type指定；

@RequestMapping
RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
RequestMapping注解有六个属性

1、 value， method；
value：     指定请求的实际地址，指定的地址可以是URI Template 模式（后面将会说明）；
method：  指定请求的method类型， GET、POST、PUT、DELETE等；

2、 consumes，produces；
consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
produces:    指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；

3、 params，headers；
params： 指定request中必须包含某些参数值是，才让该方法处理。
headers： 指定request中必须包含某些指定的header值，才能让该方法处理请求。

Filter
1、拦截器是基于java的反射机制的，而过滤器是基于函数回调 
2、过滤器依赖与servlet容器，而拦截器不依赖与servlet容器 
3、拦截器只能对action请求起作用，而过滤器则可以对几乎所有的请求起作用 
4、拦截器可以访问action上下文、值栈里的对象，而过滤器不能 
5、在action的生命周期中，拦截器可以多次被调用，而过滤器只能在容器初始化时被调用一次 
拦截器 ：是在面向切面编程的就是在你的service或者一个方法，前调用一个方法，或者在方法后调用一个方法比如动态代理就是拦截器的简单实现，在你调用方法前打印出字符串（或者做其它业务逻辑的操作），
也可以在你调用方法后打印出字符串，甚至在你抛出异常的时候做业务逻辑的操作。 


Servlet初始化过程：
在启动Web项目时，容器(比如Tomcat)会读web.xml配置文件中的两个节点<listener>和<contex-param>。
接着容器会创建一个ServletContext(上下文),应用范围内即整个WEB项目都能使用这个上下文。
接着容器会将读取到<context-param>转化为键值对,并交给ServletContext。
容器创建<listener></listener>中的类实例,即创建监听（备注：listener定义的类可以是自定义的类但必须需要继承ServletContextListener）。
在监听的类中会有一个contextInitialized(ServletContextEvent event)初始化方法，在这个方法中可以通过event.getServletContext().getInitParameter("contextConfigLocation") 
来得到context-param 设定的值。在这个类中还必须有一个contextDestroyed(ServletContextEvent event) 销毁方法.用于关闭应用前释放资源，比如说数据库连接的关闭。
得到这个context-param的值之后,你就可以做一些操作了.注意,这个时候你的WEB项目还没有完全启动完成.这个动作会比所有的Servlet都要早。
由上面的初始化过程可知容器对于web.xml的加载过程是context-param >> listener  >> fileter  >> servlet




本项目参考以下资料博客:<br>
mybatis官方文档<br>
http://www.mybatis.org/mybatis-3/zh/dynamic-sql.html<br>
一个web项目web.xml的配置中<context-param>配置作用<br>
http://blog.csdn.net/sxbjffsg163/article/details/9955479<br>
Mybatis下mapper映射文件配置之insert、update、delete<br>
http://blog.csdn.net/summer_yuxia/article/details/53171794<br>
on条件与where条件的区别<br>
http://blog.csdn.net/xc008/article/details/2872310<br>
js(jQuery)获取时间的方法及常用时间类<br>
http://www.cnblogs.com/LiuJL/p/5417685.html<br>
js获取本地ip和地区<br>
http://www.qdfuns.com/notes/39969/29a48897e9c6d6d070393e483877ab6b.html<br>
Java中的Filter过滤器<br>
http://www.cnblogs.com/coderland/p/5902878.html<br>
Java中Filter、Servlet、Listener的学习<br>
http://blog.csdn.net/agileclipse/article/details/9014683<br>
自动登录：Filter,Session,Cookie综合例子<br>
http://blog.csdn.net/ghbfgb/article/details/53001386<br>
Servlet基础知识详解
http://blog.csdn.net/jpzhu16/article/details/51626495
监听器（Listener）
http://blog.csdn.net/hzc543806053/article/details/7450812
lombok使用
http://blog.csdn.net/ghsau/article/details/52334762
学习:
Java反射机制详解
http://baike.xsoftlab.net/view/209.html#1













