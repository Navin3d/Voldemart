package gmc.project.voldemart.commands;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserCommand {
	
	@JsonIgnore
	private Long id;
	
	private String userName;
	private String password;
	private String confirmPassword;
	private String email;
	private LocalDateTime createdAt;

}
