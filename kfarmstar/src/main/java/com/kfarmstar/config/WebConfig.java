
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
  .addPathPatterns("/**")
  .excludePathPatterns("/asset/**")
  .excludePathPatterns("/build/**")
  .excludePathPatterns("/vendors/**");
  
  
  registry.addInterceptor(loginInterceptor) 
  .addPathPatterns("/**")
  .excludePathPatterns("/asset/**")
  .excludePathPatterns("/build/**")
  .excludePathPatterns("/vendors/**")
  .excludePathPatterns("/images/**")
  .excludePathPatterns("/userMain")
  .excludePathPatterns("/userMember/beforeAddMember")
  .excludePathPatterns("/userMember/addMember")
  .excludePathPatterns("/userMember/addSellerMember")
  .excludePathPatterns("/userMember/login")
  .excludePathPatterns("/userGoods/**");
  
  WebMvcConfigurer.super.addInterceptors(registry);
  
  }
  
  }
 