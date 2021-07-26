package com.qf.takeaway.config;

import com.qf.takeaway.config.RestAuthorizationEntryPoint;
import com.qf.takeaway.config.RestfulAccessDeniedHandler;
import com.qf.takeaway.entity.User;
import com.qf.takeaway.filter.JwtAuthenticationFilter;
import com.qf.takeaway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private RestAuthorizationEntryPoint restAuthorizationEntryPoint;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置 security 走我们自己重新的userDetailsService方法
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    //全局配置放行路径
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/login",
                "/logout",
                "/css/**",
                "/js/**",
                "index.html",
                "favicon.ico",
                "/docs.html",
                "/webjars/**",
                "/swagger-resources/**",
                "/v2/api-docs/**"


        );
    }

    //spring security 完整配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //使用JWT 不需要CSRF
        http.csrf()
                .disable()
                //基于token 不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //允许登录访问 已经接口访问
                .antMatchers("/login","/logout","/docs.html","/v2/api-docs", "/swagger-resources/configuration/ui",
                        "/swagger-resources", "/swagger-resources/configuration/security",
                        "/swagger-ui.html", "/webjars/**","/goods/**","/order/**","/pic/**","/img/**","/shops/**","/orderlist/**","/user/**")
                .permitAll()
                //拦截其他请求  都需要认证
                .anyRequest()
                .authenticated()
                .and()
                .headers()
                .cacheControl();

        //配置JWT 拦截器
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        //添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthorizationEntryPoint);

    }

    @Bean
    @Override
    //重写方法
    public UserDetailsService userDetailsService(){
        return username->{
            User user = userService.getUserByName(username);
            if(user!=null){
                return user;
            }
            return null;
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        //返回PasswordEncoder的具体实现
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(){
        return new JwtAuthenticationFilter();
    }
}
