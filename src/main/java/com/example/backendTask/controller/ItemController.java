package com.example.backendTask.controller;

import com.example.backendTask.DTO.ItemRequestDTO;
import com.example.backendTask.DTO.ItemResponseDTO;
import com.example.backendTask.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    // Service layer dependency for handling business logic
    private final ItemService itemService;

    /**
     * POST API to add a new item into in-memory storage (ArrayList).
     * Input validation is handled using @Valid and DTO validations.
     */
    @PostMapping
    public ResponseEntity<ItemResponseDTO> addItem(@Valid @RequestBody ItemRequestDTO item) {
        ItemResponseDTO savedItem = itemService.addItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    /**
     * GET API to fetch a single item by its ID.
     * If item is not found, ResourceNotFoundException will be thrown from service layer.
     */
    @GetMapping("/getitem/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id) {
        ItemResponseDTO item = itemService.getItemById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
}
