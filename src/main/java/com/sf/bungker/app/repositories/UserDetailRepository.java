package com.sf.bungker.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sf.bungker.app.entities.UserDetail;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long>{

}
