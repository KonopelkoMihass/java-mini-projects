package com.example.rest_service;

import org.springframework.data.jpa.repository.JpaRepository;

// This interface will allow CRUD access to DB, or more specifically, the table for Items
interface ItemRepository extends JpaRepository<Item, Long>{

}
