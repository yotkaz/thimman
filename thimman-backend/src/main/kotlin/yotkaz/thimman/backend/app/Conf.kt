package yotkaz.thimman.backend.app

import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CsrfTokenRepository
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository

//@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//open class SecurityConfiguration : WebSecurityConfigurerAdapter() {
//
//    override fun configure(http: HttpSecurity?) {
//        http!!
//            .httpBasic()
//                .and()
//            .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//            .csrf()
//                .csrfTokenRepository(csrfTokenRepository());
//    }
//
//    private fun csrfTokenRepository(): CsrfTokenRepository {
//        with(HttpSessionCsrfTokenRepository()) {
//            setHeaderName("X-XSRF-TOKEN");
//            return this;
//        }
//    }
//
//}