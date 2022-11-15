package gongo.gongo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import gongo.gongo.enums.UserRoles;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
 
@Getter
@Setter
@ToString
@Entity
public class Member extends CommonEntity {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
 
	@Column(unique = true)
	private String email;

	private String name;
	
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRoles role;
 
	// public static Member createMember(JoinFormDTO joinFormDto, PasswordEncoder passwordEncoder) {
    //     Member member = new Member();
    //     member.setName(joinFormDto.getName());
    //     member.setEmail(joinFormDto.getEmail());
    //     String password = passwordEncoder.encode(joinFormDto.getPassword());
    //     member.setPassword(password);
    //     member.setRole(UserRoles.ADMIN);
    //     return member;
    // }
}