package com.naveen.bookmyshow.DAO;

import com.naveen.bookmyshow.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User,Integer> {
    public User findByEmailId(@Param("email") String email);
}
