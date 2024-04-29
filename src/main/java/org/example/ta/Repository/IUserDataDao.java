package org.example.ta.Repository;

import org.example.ta.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDataDao extends JpaRepository<UserData,String> {
    UserData findByEmail(String email);
}
