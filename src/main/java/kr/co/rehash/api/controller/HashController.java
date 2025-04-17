package kr.co.rehash.api.controller;

import kr.co.rehash.api.domain.Hash;
import kr.co.rehash.api.service.HashService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hash")
@RequiredArgsConstructor
public class HashController {

    private final HashService hashService;

    // Create a new Hash entry
    @PostMapping
    public ResponseEntity<Hash> createHash(@RequestBody Hash hash, @RequestParam Long userId) {
        Hash createdHash = hashService.createHash(hash, userId);
        return ResponseEntity.ok(createdHash);
    }

    // Get all Hash entries (Filtered by status)
    @GetMapping
    public ResponseEntity<List<Hash>> getAllHash(@RequestParam(required = false, defaultValue = "ACTIVE") Hash.Status status) {
        List<Hash> hashList = hashService.getAllHashByStatus(status);
        return ResponseEntity.ok(hashList);
    }

    // Get a single Hash entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<Hash> getHashById(@PathVariable Long id) {
        Hash hash = hashService.getHashById(id);
        return ResponseEntity.ok(hash);
    }

    // Update an existing Hash entry
    @PutMapping("/{id}")
    public ResponseEntity<Hash> updateHash(@PathVariable Long id, @RequestBody Hash updatedHash) {
        Hash updated = hashService.updateHash(id, updatedHash);
        return ResponseEntity.ok(updated);
    }

    // Delete a Hash entry (Soft delete: Set status to INACTIVE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHash(@PathVariable Long id) {
        hashService.deleteHash(id);
        return ResponseEntity.noContent().build();
    }

}
