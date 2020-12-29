package api.users.es.users.validators;

import api.users.es.users.entity.User;
import api.users.es.users.exceptions.ValidateServiceException;

public class UserValidator {
	public static void save(User user)
	{
		if(user.getName() == null || user.getName().trim().isEmpty())
		{
			throw new ValidateServiceException("Invalid input: El nombre es obligatorio");
		}
		
		if(user.getName().length() > 100)
		{
			throw new ValidateServiceException("Invalid input: El nombre es muy largo (max 100");
		}
		
		if(user.getEmail() == null || user.getEmail().trim().isEmpty())
		{
			throw new ValidateServiceException("Invalid input: El email es obligatorio");
		}
		
		if(user.getEmail().length() > 500)
		{
			throw new ValidateServiceException("Invalid input: El email es muy largo (max 500");
		}
	}
}
