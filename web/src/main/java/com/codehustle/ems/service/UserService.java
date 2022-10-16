package com.codehustle.ems.service;

import com.codehustle.ems.entity.UserEntity;
import com.codehustle.ems.exceptions.ConflictException;
import com.codehustle.ems.exceptions.ServiceException;

public interface UserService {

    UserEntity signUpUser(UserEntity userEntity) throws ServiceException;

    UserEntity loginUser(UserEntity userEntity) throws ServiceException;
}
