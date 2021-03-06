package gmc.project.voldemart.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import gmc.project.voldemart.commands.UpdateUserCommand;
import gmc.project.voldemart.domain.User;

@Component
public class UserToUpdateUserCommand implements Converter<User, UpdateUserCommand>{

	@Override
	@Nullable
	public UpdateUserCommand convert(User source) {
		
		if(source == null)
			return null;
		
		UpdateUserCommand updateUserCommand = new UpdateUserCommand();
		updateUserCommand.setId(source.getId());
		updateUserCommand.setFirstName(source.getFirstName());
		updateUserCommand.setLastName(source.getLastName());
		updateUserCommand.setUserName(source.getUserName());
		updateUserCommand.setPassword(source.getPassword());
		updateUserCommand.setEmail(source.getEmail());
		updateUserCommand.setPhoneNumber(source.getPhoneNumber());
		updateUserCommand.setProfilePic(source.getProfilePic());
		
		return updateUserCommand;
		
	}

}
