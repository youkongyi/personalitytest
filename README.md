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

本项目参考以下资料博客:
mybatis官方文档
http://www.mybatis.org/mybatis-3/zh/dynamic-sql.html
一个web项目web.xml的配置中<context-param>配置作用
http://blog.csdn.net/sxbjffsg163/article/details/9955479
Mybatis下mapper映射文件配置之insert、update、delete
http://blog.csdn.net/summer_yuxia/article/details/53171794
on条件与where条件的区别
http://blog.csdn.net/xc008/article/details/2872310