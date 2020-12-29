package api.users.es.users.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.users.es.users.entity.User;
import api.users.es.users.exceptions.GeneralServiceException;
import api.users.es.users.exceptions.NoDataFoundException;
import api.users.es.users.exceptions.ValidateServiceException;
import api.users.es.users.repository.UserRepository;
import api.users.es.users.validators.UserValidator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List <User> findAll(Pageable page)
	{
		try {
			List<User> users= userRepository.findAll(page).toList();
			
			return users;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	public User findById(Long userId)
	{
		try {
			User user= userRepository.findById(userId)
					.orElseThrow(() -> new NoDataFoundException("User not found"));
			
			return user;
		}catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e){
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	@Transactional
	public User create(User user)
	{
		try {
			UserValidator.save(user);
			
			User newUser= userRepository.save(user);
			return newUser;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	@Transactional
	public User update(Long userId, User user)
	{
		try {
			UserValidator.save(user);
			
			User existUser= userRepository.findById(userId)
					.orElseThrow(() -> new NoDataFoundException("User not found"));
			
			existUser.setName(user.getName());
			existUser.setEmail(user.getEmail());
			
			userRepository.save(existUser);
			
			return existUser;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	@Transactional
	public void delete(Long userId)
	{
		try {
			User user= userRepository.findById(userId)
					.orElseThrow(() -> new NoDataFoundException("User not found"));
			
			userRepository.delete(user);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
}
