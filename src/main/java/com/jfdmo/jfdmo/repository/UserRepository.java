package com.jfdmo.jfdmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jfdmo.jfdmo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("From User where id= :id")
	User findByIdAndDeletedFalse(@Param("id") Long id);

}
