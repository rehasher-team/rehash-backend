package kr.co.rehash.api.service;

import kr.co.rehash.api.domain.Hash;
import kr.co.rehash.api.domain.HashItem;
import kr.co.rehash.api.repository.HashItemRepository;
import kr.co.rehash.api.repository.HashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HashItemService {

    private final HashItemRepository hashItemRepository;
    private final HashRepository hashRepository;

    public HashItem createHashItem(HashItem hashItem) {
        return hashItemRepository.save(hashItem);
    }

    public List<HashItem> getItemsByHash(Long parentId) {
        Hash parent = hashRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("HashParent not found with ID: " + parentId));
        return hashItemRepository.findByHashAndStatus(parent, HashItem.Status.ACTIVE);
    }

    public HashItem updateHashItem(Long id, HashItem updatedItem) {
        HashItem existingItem = hashItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HashItem not found with ID: " + id));
        existingItem.setTitle(updatedItem.getTitle());
        existingItem.setContent(updatedItem.getContent());
        existingItem.setPosition(updatedItem.getPosition());
        return hashItemRepository.save(existingItem);
    }

    public void deleteHashItem(Long id) {
        HashItem item = hashItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HashItem not found with ID: " + id));
        item.setStatus(HashItem.Status.INACTIVE);
        hashItemRepository.save(item);
    }

}
