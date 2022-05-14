# HttpStatusDogs 🐶
### Spring starter that provides a perfect description for your server's responses

---
[![Build Status](https://travis-ci.org/michaelfmnk/httpstatusdogs.svg?branch=master)](https://travis-ci.org/michaelfmnk/httpstatusdogs) 


HttpStatusDogs adds to Spring Context Controller Advice that adds to all server responses a header 'StatusDog'
with link to an image that properly represents what has actually happened. 
Link examples: 
 - https://httpstatusdogs.com/img/100.jpg
 - https://httpstatusdogs.com/img/200.jpg
 - https://httpstatusdogs.com/img/500.jpg
 - etc.
 
 ### Usage
 
To start using HttpStatusDogs, just include the following dependency in your `build.gradle`
```groovy
implementation 'dev.fomenko:httpstatusdogs:1.0.0'
```

or `pom.xml` file:
```xml

 <dependency>
    <groupId>dev.fomenko</groupId>
    <artifactId>httpstatusdogs</artifactId>
    <version>1.0.0</version>
 </dependency>
```

### Example

```java
  @RestController
  class FakeController {
         @GetMapping("/404")
         public String method404(HttpServletResponse response) {
              response.setStatus(404);
              return "Test";
         }
  }
```
  For the given RestController response will be:
  
```http request
HTTP/1.1 404 
StatusDog: https://httpstatusdogs.com/img/404.jpg
Content-Type: text/plain;charset=UTF-8
Content-Length: 5
Date: Tue, 09 Jul 2019 20:42:44 GMT

Test
``` 

 

 All images are provided by [HttpStatusDogs](https://httpstatusdogs.com)
