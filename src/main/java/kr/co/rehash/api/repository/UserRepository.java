package kr.co.rehash.api.repository;

import kr.co.rehash.api.domain.Hash;
import kr.co.rehash.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

}
