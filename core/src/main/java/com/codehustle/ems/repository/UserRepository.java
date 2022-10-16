package com.codehustle.ems.repository;

import com.codehustle.ems.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByUserEmailIdOrUserPhoneNo(String emailId,String phoneNo);

    UserEntity findByUserEmailId(String emailId);
}
