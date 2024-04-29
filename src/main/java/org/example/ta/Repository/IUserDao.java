package org.example.ta.Repository;

import org.example.ta.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}