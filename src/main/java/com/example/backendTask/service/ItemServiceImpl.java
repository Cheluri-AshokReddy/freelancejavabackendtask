package com.example.backendTask.service;

import com.example.backendTask.DTO.ItemRequestDTO;
import com.example.backendTask.DTO.ItemResponseDTO;
import com.example.backendTask.Model.Item;
import com.example.backendTask.exceptions.APIException;
import com.example.backendTask.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    // In-memory storage using ArrayList (data will reset when application restarts)
    private final List<Item> items = new ArrayList<>();

    // Counter to generate unique IDs for each item
    private Long idCounter = 1L;

    // ModelMapper is used for converting DTO <-> Entity/Model
    private final ModelMapper modelMapper;

    /**
     * Adds a new item into the in-memory ArrayList.
     * Also checks for duplicate item name before adding.
     *
     * @param itemRequestDTO request body containing item details
     * @return saved item response with generated ID
     */
    public ItemResponseDTO addItem(ItemRequestDTO itemRequestDTO) {

        // Check if item with same name already exists (case-insensitive)
        boolean exists = items.stream()
                .anyMatch(i -> i.getName().equalsIgnoreCase(itemRequestDTO.getName()));

        if (exists) {
            throw new APIException("Item already exists with name: " + itemRequestDTO.getName());
        }

        // Convert Request DTO to Item Model
        Item item = modelMapper.map(itemRequestDTO, Item.class);

        // Generate and assign unique ID
        item.setId(idCounter++);

        // Store item in ArrayList
        items.add(item);

        // Convert saved model to Response DTO
        return modelMapper.map(item, ItemResponseDTO.class);
    }

    /**
     * Fetches a single item from in-memory storage by ID.
     *
     * @param id item ID
     * @return item response DTO
     */
    public ItemResponseDTO getItemById(Long id) {

        // Find item by ID, else throw exception
        Item item = items.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with ID: " + id));

        // Convert Item model to Response DTO
        return modelMapper.map(item, ItemResponseDTO.class);
    }
}
