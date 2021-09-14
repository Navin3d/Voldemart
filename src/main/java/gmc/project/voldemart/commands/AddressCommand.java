package gmc.project.voldemart.commands;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressCommand {
	@JsonIgnore
	private Long id;	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String landmark;
	private Long zipCode;
}
