package tssof03.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)

public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
        .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/login").permitAll()
                                .anyRequest().authenticated()
                                )
                                .formLogin(formlogin -> formlogin
                                .loginPage("/login")
                                .defaultSuccessUrl("/booklist", true)
                                .permitAll()
                                )
                                .logout(logout -> logout
                                .permitAll()
                                );
                                return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService(){

        List<UserDetails> users = new ArrayList<>();

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        
        UserDetails user = User
                        .withUsername("user")
                        .password(passwordEncoder.encode("password"))
                        .roles("USER")
                        .build();
                        users.add(user);

                    user = User
                        .withUsername("admin")
                        .password(passwordEncoder.encode("admin"))
                        .roles("USER", "ADMIN")
                        .build();
                    users.add(user);

        return new InMemoryUserDetailsManager(users);
    }
}
