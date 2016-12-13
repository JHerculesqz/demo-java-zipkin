# 目的#
 
实验SpringBoot如何集成zipkin
	
# Server端集成步骤(http方式) #
**STEP1.Gradle中引用依赖的jar**
	
	compile('io.zipkin.java:zipkin-server')
	runtime('io.zipkin.java:zipkin-autoconfigure-ui')
	
**STEP2.在XXXApplication.java增加@EnableZipkinServer**
	
**STEP3.运行Server端，查看http://localhost:9411**
	
	TODO:验证一下是否一定是9411
	
# Client端集成步骤(http方式) #

**STEP1.Gradle中引用依赖的包**
	
	compile('org.springframework.cloud:spring-cloud-starter-sleuth')
	compile('org.springframework.cloud:spring-cloud-starter-zipkin')
	
**STEP2.修改application.yml**
	
	spring:
	  application:
	    name: zipkinClient
      sleuth:
        sampler:
          percentage: 0.5
	  zipkin:
	    enabled: true
	    baseUrl: http://localhost:9411/
	  sample:
	    zipkin:
	      enabled: true

	TODO:sleuth.sampler.percentage待验证
	TODO:现在是用InMemoryStorage，后续要修改成其他的Storage
	
**STEP3.在xxxxApplication.java中，增加采样器(不喜欢这段代码)**
	
	@Bean
	Sampler sampler() {
		return new AlwaysSampler();
	}
	
	TODO:如果采用sleuth.sampler.percentage，应该不需要STEP3,待验证
	
**STEP4.使用HttpUtilsEx、ZipkinUtils两个工具类分别可监控post链和线程链**
	
	详细技术点不赘述，详见代码
	潜规则1：RestTemplate不能反复new，1个服务只能有1个javabean，这是zipkin调用链成链的关键
	潜规则2：Zipkin监控线程需要使用Tracer

	TODO:Hystrix的Command如何监控？
	
**STEP5.运行Client端，查看http://localhost:7000**

# 代码样例说明 #
	
	本demo中http://localhost:7000/zipkin/client/span1启动1个线程，
	线程中调用http://localhost:7010/zipkin/client/span2，
	span2中又调用http://localhost:7000/zipkin/client/span3
	调用链为：span1->spanInThread->span2->span3
	
# Server端、Client端集成步骤(stream方式) #
	
	详见代码注释掉的地方，
	好吧，我懒得写了
	好吧，我还很讨厌Stream方式，因为要下载rabbit/erlang，手机流量谁给报一下...
	
# reference #
	
	http://cloud.spring.io/spring-cloud-static/Brixton.SR7/
	https://segmentfault.com/a/1190000005177766
	http://ryanjbaxter.com/cloud/spring%20cloud/spring/2016/07/07/spring-cloud-sleuth.html----这篇文章请反复阅读，真理就在其中
	https://spring.io/blog/2016/02/15/distributed-tracing-with-spring-cloud-sleuth-and-spring-cloud-zipkin
	http://zipkin.io/pages/existing_instrumentations.html
	
	抓包
	http://blog.csdn.net/xukai871105/article/details/31008635
	抓localhost包
	https://wiki.wireshark.org/CaptureSetup/Loopback
	Stream模式下需要配置rabbit
	http://docs.spring.io/spring-boot/docs/1.4.2.RELEASE/reference/htmlsingle/#boot-features-rabbitmq
	rabbit如何使用
	https://www.rabbitmq.com/management.html
	