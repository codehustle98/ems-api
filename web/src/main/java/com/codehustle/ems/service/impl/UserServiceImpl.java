package com.codehustle.ems.service.impl;

import com.codehustle.ems.constants.MessageConstants;
import com.codehustle.ems.entity.EmployeeEntity;
import com.codehustle.ems.entity.UserEntity;
import com.codehustle.ems.exceptions.ConflictException;
import com.codehustle.ems.exceptions.NotFoundException;
import com.codehustle.ems.exceptions.ServiceException;
import com.codehustle.ems.repository.UserRepository;
import com.codehustle.ems.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;
import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity signUpUser(UserEntity userEntity) throws ServiceException {
        try{
            UserEntity existingUser = userRepository.findByUserEmailIdOrUserPhoneNo(userEntity.getUserEmailId(),userEntity.getUserPhoneNo());
            if(existingUser != null)
                throw new ConflictException(MessageConstants.USER_EXISTS);
            userEntity.setUserPassword(new Base64().encodeToString(userEntity.getUserPassword().getBytes()));
            return userRepository.save(userEntity);
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public UserEntity loginUser(UserEntity userEntity) throws ServiceException {
        try{
            UserEntity user = userRepository.findByUserEmailId(userEntity.getUserEmailId());
            if(user == null)
                throw new NotFoundException(MessageConstants.INVALID_CREDENTIALS);
            byte[] decodedPassword = new Base64().decode(user.getUserPassword());
            if(userEntity.getUserPassword().equals(new String(decodedPassword))){
                return user;
            }else{
                throw new AuthException(MessageConstants.INVALID_PASSWORD);
            }
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }
}
