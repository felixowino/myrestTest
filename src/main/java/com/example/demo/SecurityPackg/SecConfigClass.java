package com.example.demo.SecurityPackg;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.demo.ServicePackg.myUsersConfigClass;

//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecConfigClass {
//	
//	@Autowired
//    private CorsConfigurationSource corsConfigurationSource;
//	

	@Autowired
	private myUsersConfigClass myusers;

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080/*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
////		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
////		configuration.setExposedHeaders(Arrays.asList("Authorization", "Content-Disposition"));
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}

//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable()).cors(Customizer.withDefaults())
//				// .cors().disable()
//				.authorizeRequests(authorize -> {
//					try {
//
//						authorize.antMatchers("/", "/adduser", "/mylogin", "/dummy").permitAll().antMatchers("/dltrecord")
//								.hasAuthority("ADMIN").antMatchers("/ddRecord").hasAnyAuthority("CREATOR", "ADMIN")
//								.antMatchers("/updrecord").hasAuthority("ADMIN").anyRequest().authenticated().and()
//								.formLogin().permitAll().and().logout().logoutUrl("/logout")
//								.logoutSuccessUrl("/").permitAll();
//					} catch (Exception e) {
//  
	
	//A4B2F62EB4DE6EFA9AD430E3711458F9
	
//						e.printStackTrace();
//					}
//				});
//
//		return http.build();
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http.csrf(csrf -> csrf.disable())
	        .cors(Customizer.withDefaults())
	        .authorizeRequests(authorize -> authorize
	            .antMatchers("/", "/adduser", "/mylogin", "/dummy").permitAll()
	            .antMatchers("/dltrecord").hasAuthority("ADMIN")
	            .antMatchers("/ddRecord").hasAnyAuthority("CREATOR", "GUEST", "NORMAL USER")
	            .antMatchers("/updrecord").hasAuthority("ADMIN")
	            .anyRequest().authenticated())
	        .formLogin().permitAll()
	        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll()
	        .and().build();
	}

	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public void configure(WebSecurity web) throws Exception {
//		// Allow anonymous access to the static resources
//		web.ignoring().antMatchers("/resources/**");
//	}

	@Bean
	public PasswordEncoder getmencoder() {
		return new BCryptPasswordEncoder();
	}

//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.userDetailsService(myusers);
//
//	}
	
	
	
	
	
	

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(Collections.singletonList(authenticationProvider()));
    }
	
	
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myusers);
        authProvider.setPasswordEncoder(getmencoder());
        return authProvider;
    }
	
	
	

}
