package gmc.project.voldemart.commands;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gmc.project.voldemart.domain.States;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserCommand {
	
	@JsonIgnore
	private Long id;
	
	@NotBlank
	@Size(max = 15)
	private String firstName;
	@NotBlank
	@Size(max = 15)
	private String lastName;
	private String userName;
	private String password;
	@Email
	private String email;	
	private Byte[] profilePic;
	@NotBlank
	@Size(max = 13, min = 10)
	private String phoneNumber;
	@JsonIgnore
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt = LocalDateTime.now();

}
