
  package com.kfarmstar.config;
  
  import org.springframework.context.annotation.Configuration; 
  import org.springframework.web.servlet.config.annotation.InterceptorRegistry; 
  import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
  
  import com.kfarmstar.interceptor.CommonInterceptor; import
  com.kfarmstar.interceptor.LoginInterceptor;
  
  @Configuration
  public class WebConfig implements WebMvcConfigurer {
  
  private CommonInterceptor commonInterceptor; 
  private LoginInterceptor loginInterceptor;
  
  public WebConfig(CommonInterceptor commonInterceptor, LoginInterceptor loginInterceptor) {
	  this.commonInterceptor = commonInterceptor;
	  this.loginInterceptor = loginInterceptor; 
  }
  
  @Override public void addInterceptors(InterceptorRegistry registry) {
  
  registry.addInterceptor(commonInterceptor) 
  .excludePathPatterns("/**");
  
  registry.addInterceptor(loginInterceptor) 
  .excludePathPatterns("/**");
  
  
  WebMvcConfigurer.super.addInterceptors(registry);
  
  }
  
  }
 