package gongo.gongo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_user")
@DynamicUpdate
public class User extends CommonEntity {
 
	@Id
	@Column(name = "id", unique = true)
	private String id;
 
	@Column(name = "password")
	private String password;
 
	@Column(name = "name")
	private String name;
 
	// @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	// @JoinTable(name = "tb_user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	// private Set<Role> roles;
 
	// @Builder
	// public User(String id, String password, String name, Set<Role> roles) {
	// 	this.id = id;
	// 	this.password = password;
	// 	this.name = name;
	// 	this.roles = roles;
	// }
}