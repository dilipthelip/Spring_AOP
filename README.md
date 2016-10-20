# Spring_AOP

Aspect = Advice + PointCut
Advice - What code is executed 
PointCut= Where the code is executed.

Aspects are Spring beans that marks them with @Aspect annotation.

Advices are methods.

PointCut:					
execution(* doSomeThingElse(..))
		  |				|
	Represents the Represents the methodName
	return type
	.. -> This represents the infinite number of parameters.




SimpleAspectConfiguration -> This class acts as a Spring base class to create the Spring Beans by scanning the package.

@Configuration -> indicates that the class can be used by the Spring IoC container as a source of bean definitions.This annotation is repsonsible for making the class behave as a equivalenet to the Spring Bean XML file.
@EnableAspectJAutoProxy
@ComponentScan(basePackages="com.learnspringaop")

Exceptions:
The reason for the below exception is that the pointcut is very broad. Spring AOP creates proxies  for every class out there and some are declared final and that is the reason why it is not able to subclass that particular class.
Caused by: java.lang.IllegalArgumentException: Cannot subclass final class org.springframework.boot.autoconfigure.AutoConfigurationPackages$BasePackages
	at org.springframework.cglib.proxy.Enhancer.generateClass(Enhancer.java:565) ~[spring-core-4.3.3.RELEASE.jar:4.3.3.RELEASE]