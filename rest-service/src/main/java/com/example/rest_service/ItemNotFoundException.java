package com.example.rest_service;

public class ItemNotFoundException extends RuntimeException {
    ItemNotFoundException(Long id) {
        super("Could not find item " + id);
    }
}
