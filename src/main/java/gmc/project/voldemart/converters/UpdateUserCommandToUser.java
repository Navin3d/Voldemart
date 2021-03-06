package gmc.project.voldemart.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import gmc.project.voldemart.commands.UpdateUserCommand;
import gmc.project.voldemart.domain.User;

@Component
public class UpdateUserCommandToUser implements Converter<UpdateUserCommand, User>{

	@Override
	@Nullable
	public User convert(UpdateUserCommand source) {
		
		if(source == null)
			return null;
		
		User user = new User();
		user.setId(source.getId());
		user.setFirstName(source.getFirstName());
		user.setLastName(source.getLastName());
		user.setUserName(source.getUserName());
		user.setPassword(source.getPassword());
		user.setEmail(source.getEmail());
		user.setPhoneNumber(source.getPhoneNumber());
		user.setProfilePic(source.getProfilePic());
		user.setModifiedAt(source.getModifiedAt());
		
		return user;
		
	}

}
