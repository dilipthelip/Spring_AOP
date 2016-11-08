# Spring_AOP

Aspect = Advice + PointCut
Advice - What code is executed  
PointCut= Where the code is executed.

Aspects are Spring beans that marks them with @Aspect annotation.

Advices are methods.

## Types of Advice:

[Advice Types](https://github.com/dilipthelip/Spring_AOP/blob/master/TypesOFAdvice.png)

**Before Advice:**

Executed before method.
Exception Prevents method to be executed.

**After Advice:**

Execute after the method exexutes successfully.

**After Throwing Advice:**

Executed if the method threw an exception.
Exception will be proogated to the caller

**After Returning Advice:**

Executed if the method returns successfully.
Can access the result.
Type Safe. You can define for which return type this particular advice can be executed.

**Around Advice:**

Wraps around the method.
Can prevent the original method from being called.
Only advice that can catch exceptions
Only advice that can modify return value.
Current method call is passed to the advice - ProceedingJoinPoint
Can be executed or skipped if you dont call the proceed method on the ProceedingJointPoint.

This is the most powerful advice. It can be used instead of a before or after advice. Around is powerful and complex.

The recommendation is to use the appropriate advice.

## PointCut:					
execution(* doSomeThingElse(..))
		  |				|
	Represents the Represents the methodName
	return type
	.. -> This represents the infinite number of parameters.

Examples:  
**Methods:**  
execution -> Method Execution.  
execution(* hello()) 			-> Execution of method hello, no parameters and any return type.  
execution(* hello(int , int )) 	-> Execution of method hello, two int parameters and any return type.  
execution(* hello(*)) 			-> Execution of method hello, one parameter of any type and any return type.  


**Package and Classes:**  
execution(int com.xyz.Hello.execute(int))	->	Execution of method execute in Hello class in package com.xyz, One int parameter, int return type.  
execution(* com.xyz.*Service.*(..))			->	Execution of any method in class file that ends with name Service, in package com.xyz , any parameter, any return type.  
execution(* com.xyz..*Service.*(..))		->	Execution of any method in class file that ends with name Service, in package com.xyz or Subpackage, any parameter, any return type.  
execution(* *.*(..))						->	Execution of any method, any parameters in any class,in the default package only.  
execution(* *..*(..))						->	Execution of any method, any parameters in any class,in any package or subpackage.  
 

**Spring Bean names as Pointcuts:**  
@Around("bean(*Service)") -> This point cut is executed for all classes whose bean name ends with Service.  
BeanNameAspect.java  

**@PointCut:**  
How to reuse pointCuts ?  
  
**Architecture Problems :**  

For each Call to the service :  
	Call must be traced
	Exception should be logged.  

Add AOP only to specific parts of the application.

Define Architecute as pointcuts.    
Define behavior using advices.  
Add advices to correct Pointcuts.  

Spring org.springframework.sterotype package has the below annotations.
@Service  
@Component  
@Repository  

The above annotations are no different for Spring Dependency injection. Those will be treated as a regular bean.  

**Expressing Architecutre with Annotations:**  

execution(* (@org.springframework.stereotype.Repository *).*(..))	-> This pointcut will be invoked for all the Classes that are annotated with @Repository annotation.  
execution(* (@org.springframework.stereotype.Service *).*(..))	-> This pointcut will be invoked for all the Classes that are annotated with @Service annotation.

Check the below classes for the Architecture level exception handling that covers all the class that are annotated with @Service and @Repository.  
ExceptionLoggingAspect  
ArchitecutreService  
ArchitectureServiceTest  

**Expressing Architecutre with packageNames:**  

execution(* com.learnspringaop..repository.*.*(..))	-> Any class in a subpackage repository of com.learnspringaop.  
.. -> This double dot is to match any number of packages/folders between learnspringaop and repository package.  
execution(* com.learnspringaop..service.*.*(..))	-> Any class in a subpackage repository of com.learnspringaop.

**How aspects are added to objects?**  
Proxies are created around the original object when AOP is enabled. Proxies are just like original objects but advices are added on top of it.  

	
[How aspects are created ?](https://github.com/dilipthelip/Spring_AOP/blob/master/How%20Aspects%20are%20added%20to%20Objects.png)  

Proxies are created either via Dynamic proxies(part of JDK) or CGLIB proxies.    
Local method calls never reaches the proxy and advice will never be executed.  
For Example :- In the below case if the call is made via callsTransactionalMethod() then the Spring proxy will never come in to picture and because this is like a local method call.  

@Service  
public class LocalMethodService {  

	@Transactional  
	public void transactionalMethod(){   
		
	}  
	
	public void callsTransactionalMethod(){  
		transactionalMethod();  
	}  
}  

CGLIB vs Dynamic Proxies:  
Check the below classed to understand.  
DemoClassImpl  
DemoClass  
DemoClassTest  

### How proxies are implemented ?  

**CGLIB:**  
Subclasses dynamically create subclass.  
Subclass implements proxy.  

**Dynamic proxy:**  
Feature of the JDK.  
For Interfaces only.

**Usage of CGLIB:**  
If no interfaxce is implemented.  
if proxy target class is set to true.  

If a interface is available then JDK dynamic proxies will create proxy only for the Interface. If you do not have interface that have the method declared in it then   
this will fail.  

Fix in this case:
Use CGLIB instead of JDK dynamic proxy.  
Set the attribute @EnableAspectJAutoProxy(proxyTargetClass=true) to force Spring to use CGLIB instead of Dynamic proxy.  

### Limitation of AOP Proxy model:  
Works only on public methods.  
No private or protected methods.  
Works only on methods from outside.  
We cannot use Spring AOP without spring dependency injection.  

## AspectJ:  
A different system for AOP in java.  
	>	Faster  
	>	Powerful  
	>	Spring AOP uses the same syntax.
	>	Only the bean PointCut expressions wont work.
			'@Around("bean(*Service)")'    
			
AspectJ used Bytecode Weaving.  
i.e., classes and aspect are woven in to the Byte code.  

Weaving might happen :  
	When classes are loaded.  
	When code is compiled.  
	Check the below picture.  
	
[How weaving happens?](https://github.com/dilipthelip/Spring_AOP/blob/master/AspecTJ_1.png)  

### Load time Weaving :  

Aspects are woven when classes are loaded.  
Weaving configured by META-INF/aop.xml.  

<aspectj>  
	<weaver>  
		<include within="com.learnaspectjaop..*"/>  
	</weaver>  
	<aspects>  
		<aspect name="com.learnspringaspectjaop.aspect.DemoAspect"/>  
	</aspects>   
<aspectj>  

AspectJ need to modify the byte code.

SimpleAspectConfiguration -> This class acts as a Spring base class to create the Spring Beans by scanning the package.

@Configuration -> indicates that the class can be used by the Spring IoC container as a source of bean definitions.This annotation is repsonsible for making the class behave as a equivalenet to the Spring Bean XML file.
@EnableAspectJAutoProxy
@ComponentScan(basePackages="com.learnspringaop")

Exceptions:
The reason for the below exception is that the pointcut is very broad. Spring AOP creates proxies  for every class out there and some are declared final and that is the reason why it is not able to subclass that particular class.
Caused by: java.lang.IllegalArgumentException: Cannot subclass final class org.springframework.boot.autoconfigure.AutoConfigurationPackages$BasePackages
	at org.springframework.cglib.proxy.Enhancer.generateClass(Enhancer.java:565) ~[spring-core-4.3.3.RELEASE.jar:4.3.3.RELEASE]
