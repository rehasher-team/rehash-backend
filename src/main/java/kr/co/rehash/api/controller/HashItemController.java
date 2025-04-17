package kr.co.rehash.api.controller;

import kr.co.rehash.api.domain.HashItem;
import kr.co.rehash.api.service.HashItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hash-items")
@RequiredArgsConstructor
public class HashItemController {

    private final HashItemService hashItemService;

    @PostMapping
    public ResponseEntity<HashItem> createHashItem(@RequestBody HashItem hashItem) {
        HashItem createdItem = hashItemService.createHashItem(hashItem);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/parent/{parentId}")
    public ResponseEntity<List<HashItem>> getHashItemsByHash(@PathVariable Long parentId) {
        List<HashItem> items = hashItemService.getItemsByHash(parentId);
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashItem> updateHashItem(@PathVariable Long id, @RequestBody HashItem updatedItem) {
        HashItem updated = hashItemService.updateHashItem(id, updatedItem);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHashItem(@PathVariable Long id) {
        hashItemService.deleteHashItem(id);
        return ResponseEntity.noContent().build();
    }

}
