package gongo.gongo.sercurity;
// package gongo.gongo.service;

// import java.util.HashSet;
// import java.util.Set;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import gongo.gongo.entity.Role;
// import gongo.gongo.repository.UserRepository;
// import lombok.AllArgsConstructor;
 
// @Service
// @AllArgsConstructor
// public class CustomUserDetailsService implements UserDetailsService {
 
// 	private final UserRepository userRepo;
 
// 	@Override
// 	@Transactional(readOnly = true)
// 	public UserDetails loadUserByUsername(String id) {
 
// 		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
// 		gongo.gongo.entity.User user = userRepo.findOneById(id);
 
// 		if (user != null) {
// 			for (Role role : user.getRoles()) {
// 				grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
// 			}
// 			return new User(user.getId(), user.getPassword(), grantedAuthorities);
// 		} else {
// 			throw new UsernameNotFoundException("can not find User : " + id);
// 		}
// 	}
// }
