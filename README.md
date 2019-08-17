# Providers 详解
javax.ws.rs.ext.Providers是JAX-RS 2.0定义的一个辅助接口，其实现类用于完成过滤和读写拦截功能。
@Provider标注的实现类，可以在运行时自动探测、加载。
Provider实例可以通过@Context注解被依赖注入到其他实例中。
Providers接口定义了4个方法，分别用来获取MessageBodyReader、MessageBodyWriter、ExceptionMapper和ContextResolver实例。


# REST请求流程
01 客户端接收请求，进入扩展点 [ClientRequestFilter] 实现类的filter()方法。
02 第二个扩展点：客户端写拦截器WriterInterceptor实现类的aroundWriteTo()方法，实现对客户端序列化操作的拦截。
03 客户端消息体写处理器MessageBodyWriter执行序列化，过渡到服务端。
04 进入第三个扩展点：服务器前置请求过滤器ContainerRequestFilter实现类的filter()方法。
05 过滤处理完毕后，找到匹配资源方法。
06 进入第四个扩展点：服务器后置请求过滤器ContainerRequestFilter实现类的filter()方法。
07 服务器消息体读处理器MessageBodyReader完成数据流的反序列化。
08 执行资源方法。
09 进入第六个扩展点：服务器响应过滤器ContainerResponseFilter实现类的filter()方法。
10 进入第七个扩展点：服务器写拦截器WriterInterceptor实现类的aroundWriteTo()方法，实现对服务端序列化到客户端这个操作的拦截。
11 服务器消息体写处理器MessageBodyWriter执行序列化。流程返回客户端。
12 客户端接收响应，进入第八个扩展点：客户端响应过滤器ClientResponseFilter实现类的filter方法。
13 客户端响应实例response返回到用户侧，用户执行response.readEntity()，进入第九个扩展点：客户端读拦截器ReaderInterceptor实现类的aroundReadFrom()方法，对客户端反序列化进行拦截。
14 客户端消息体读处理器MessageBodyReader执行反序列化，将Java类型的对象最终作为readEntity()方法的返回值。


# REST过滤器 (JAX-RS 2.0定义了4种过滤器扩展点接口，供开发者实现业务逻辑，先后为：)
## ClientRequestFilter
## ContainerRequestFilter
## ContainerResponseFilter
## ClientResponseFilter