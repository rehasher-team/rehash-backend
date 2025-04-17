package kr.co.rehash.api.repository;

import kr.co.rehash.api.domain.Hash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HashRepository extends JpaRepository<Hash, Long> {

    List<Hash> findByStatus(Hash.Status status);

}
