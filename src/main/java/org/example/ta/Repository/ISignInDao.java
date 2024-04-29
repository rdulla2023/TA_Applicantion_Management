package org.example.ta.Repository;

import org.example.ta.DTO.SignInInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISignInDao extends JpaRepository<SignInInput, String> {
}
