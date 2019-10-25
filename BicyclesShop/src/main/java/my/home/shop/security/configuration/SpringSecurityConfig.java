package my.home.shop.security.configuration;

import my.home.shop.hendlers.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
@ComponentScan("my.home.shop")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/email/**").permitAll()
                .antMatchers("/signUp/**").permitAll()

                .antMatchers("/cart/**").authenticated()
                .antMatchers("/chat/**").authenticated()
                .antMatchers("/bicycles/**").authenticated()
                .antMatchers("/parts/**").authenticated()
                .antMatchers("/accessories/**").authenticated()
                .antMatchers("/404/**").authenticated()
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/index/**").authenticated()
                .antMatchers("/pay/**").authenticated()

                .antMatchers("/bicycles/add").hasAuthority("ADMIN")
                .antMatchers("/parts/add").hasAuthority("ADMIN")
                .antMatchers("/accessories/add").hasAuthority("ADMIN")
                .antMatchers("/users/**").hasAuthority("ADMIN")

                .and()
                .formLogin()
                .loginPage("/signIn")
                .defaultSuccessUrl("/index")
                .failureUrl("/signIn?error")
                .usernameParameter("login")
                .permitAll()

                .and()
                .exceptionHandling().accessDeniedPage("/accessDeniedPage")

                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/signIn").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)

                .and()
                .rememberMe()
                .rememberMeParameter("remember-me")
                .tokenRepository(persistentTokenRepository());
                http
                .csrf()
                .csrfTokenRepository(csrfTokenRepository());
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }

    @Autowired
    protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }
}
