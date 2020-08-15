package com.jiejie.mall.web.config;

import com.jiejie.mall.web.security.*;
import com.jiejie.mall.web.validate.smscode.SmsAuthenticationConfig;
import com.jiejie.mall.web.validate.smscode.SmsCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailService userDetailService;  //实现了UserDetailsService接口
    @Autowired
    private MyFilterInvocationSecurityMetadataSource filterMetadataSource; //权限过滤器（当前url所需要的访问权限）
    @Autowired
    private MyAccessDecisionManager myAccessDecisionManager;//权限决策器
    @Autowired
    private MyAccessDeniedHandler deniedHandler;//自定义错误(403)返回数据

    @Autowired
    private TokenAuthenticationFilter tokenAuthenticationFilter;

    public WebSecurityConfig(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/code/sms").permitAll()
                    .antMatchers("/code/image").permitAll()
                    .and().addFilterAfter(tokenAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                        @Override
                        public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                            o.setSecurityMetadataSource(filterMetadataSource);
                            o.setAccessDecisionManager(myAccessDecisionManager);
                            return o;
                        }
                    })
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(deniedHandler)
                .and().cors();



    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

    //@Autowired
    private SmsCodeFilter smsCodeFilter;

    //@Autowired
    private SmsAuthenticationConfig smsAuthenticationConfig;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");//修改为添加而不是设置，* 最好改为实际的需要，我这是非生产配置，所以粗暴了一点
        configuration.addAllowedMethod("*");//修改为添加而不是设置
        configuration.addAllowedHeader("*");//这里很重要，起码需要允许 Access-Control-Allow-Origin
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
