package gongo.gongo.sercurity;
// package gongo.gongo.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// import lombok.AllArgsConstructor;

// @AllArgsConstructor
// @EnableWebSecurity
// public class WebSecurityConfig {
    
//     private final UserDetailsService customUserDetailsService;
    
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); 
//     }
//     @Bean
// 	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// 		/* @formatter:off */
// 		http
// 			.authorizeRequests()
// 				.antMatchers("/", "/home", "/signUp", "/main.html").permitAll() // 해당 url의 접근을 permitAll()을 통해 모두 허용
// 				.anyRequest().authenticated() // 위에 설정된 url제외 다른 접근은 인증 요구
// 				.and()
// 			.formLogin()
// 				.permitAll()
// 				.loginPage("/login") // 기본 로그인 페이지
// 				.and()
// 			.logout()
// 				.permitAll()
// 				// .logoutUrl("/logout") // 로그아웃 URL (기본 값 : /logout)
// 				// .logoutSuccessUrl("/login?logout") // 로그아웃 성공 URL (기본 값 : "/login?logout")
// 				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 주소창에 요청해도 포스트로 인식하여 로그아웃
//                 .deleteCookies("JSESSIONID") // 로그아웃 시 JSESSIONID 제거
// 				.invalidateHttpSession(true) // 로그아웃 시 세션 종료
// 				.clearAuthentication(true); // 로그아웃 시 권한 제거
		
// 		return http.build();
// 		/* @formatter:on */
// 	}
//     @Autowired
//     public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {

//         auth.userDetailsService(customUserDetailsService)
//         .passwordEncoder(passwordEncoder());
//     }
// }
