package com.example.backendTask.service;

import com.example.backendTask.DTO.ItemRequestDTO;
import com.example.backendTask.DTO.ItemResponseDTO;

public interface ItemService {
     ItemResponseDTO addItem(ItemRequestDTO item);
     ItemResponseDTO getItemById(Long id);
}
