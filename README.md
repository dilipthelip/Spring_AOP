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

SimpleAspectConfiguration -> This class acts as a Spring base class to create the Spring Beans by scanning the package.

@Configuration -> indicates that the class can be used by the Spring IoC container as a source of bean definitions.This annotation is repsonsible for making the class behave as a equivalenet to the Spring Bean XML file.
@EnableAspectJAutoProxy
@ComponentScan(basePackages="com.learnspringaop")

Exceptions:
The reason for the below exception is that the pointcut is very broad. Spring AOP creates proxies  for every class out there and some are declared final and that is the reason why it is not able to subclass that particular class.
Caused by: java.lang.IllegalArgumentException: Cannot subclass final class org.springframework.boot.autoconfigure.AutoConfigurationPackages$BasePackages
	at org.springframework.cglib.proxy.Enhancer.generateClass(Enhancer.java:565) ~[spring-core-4.3.3.RELEASE.jar:4.3.3.RELEASE]
