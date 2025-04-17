package kr.co.rehash.api.repository;

import kr.co.rehash.api.domain.Hash;
import kr.co.rehash.api.domain.HashItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HashItemRepository extends JpaRepository<HashItem, Long> {
    List<HashItem> findByHashAndStatus(Hash hash, HashItem.Status status);
}
