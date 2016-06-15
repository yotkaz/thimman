package yotkaz.thimman.backend.app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CsrfTokenRepository
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import yotkaz.thimman.backend.security.ThimmanUserDetailsService

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var thimmanUserDetailsService: ThimmanUserDetailsService;

    override fun configure(http: HttpSecurity?) {
        http!!
            .httpBasic()
                .and()
            .authorizeRequests()
                .requestMatchers(RequestMatcher {
                    req -> CorsUtils.isPreFlightRequest(req)
                }).permitAll()
                .anyRequest()
                .authenticated()
                .and()
            .csrf().disable();
                //.csrfTokenRepository(csrfTokenRepository());
    }

    private fun csrfTokenRepository(): CsrfTokenRepository {
        with(HttpSessionCsrfTokenRepository()) {
            setHeaderName("X-XSRF-TOKEN");
            return this;
        }
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(thimmanUserDetailsService);
    }

}



@Configuration
open class WebConfig : WebMvcConfigurerAdapter() {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**");
    }

}