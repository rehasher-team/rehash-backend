package kr.co.rehash.api.service;

import kr.co.rehash.api.domain.Hash;
import kr.co.rehash.api.domain.User;
import kr.co.rehash.api.repository.HashRepository;
import kr.co.rehash.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HashService {

    private final HashRepository hashRepository;
    private final UserRepository userRepository;

    // Create Hash
    public Hash createHash(Hash hash, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        hash.setCreatedBy(user);
        return hashRepository.save(hash);
    }

    // Read all Hash entries
    public List<Hash> getAllHashByStatus(Hash.Status status) {
        return hashRepository.findByStatus(status);
    }

    // Retrieve Hash by ID
    public Hash getHashById(Long id) {
        return hashRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hash not found with ID: " + id));
    }

    // Update Hash
    public Hash updateHash(Long id, Hash updatedHash) {
        Hash existingHash = hashRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hash not found with ID: " + id));
        existingHash.setName(updatedHash.getName());
        existingHash.setSize(updatedHash.getSize());
        existingHash.setTags(updatedHash.getTags());
        existingHash.setStatus(updatedHash.getStatus());
        return hashRepository.save(existingHash);
    }

    // Delete Hash (Set status to INACTIVE)
    public void deleteHash(Long id) {
        Hash hash = hashRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hash not found with ID: " + id));
        hash.setStatus(Hash.Status.INACTIVE);
        hashRepository.save(hash);
    }

}
