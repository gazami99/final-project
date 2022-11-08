package gongo.gongo.dto;
 
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
	private String id;
 
	private String password;
 
	private String name;
 

	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" ID : ");
		builder.append(id);
        builder.append(" 비밀 번호: ");
		builder.append(password);
        builder.append(" 이름 : ");
		builder.append(name);
        
        return builder.toString();
    }
	
	// private Set<Long> roles;
 
	// public User toEntity(Set<Role> roles) {
	// 	return User.builder().id(id).password(password).name(name).roles(roles).build();
	// }


}