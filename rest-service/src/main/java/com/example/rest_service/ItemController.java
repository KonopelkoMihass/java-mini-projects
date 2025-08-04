package com.example.rest_service;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemModelAssembler assembler;

    ItemController(ItemRepository itemRepository, ItemModelAssembler assembler) {

        this.itemRepository = itemRepository;
        this.assembler = assembler;
    }

    @GetMapping("/items")
    CollectionModel<EntityModel<Item>> all() {
        List<EntityModel<Item>> items = itemRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(items,
                linkTo(methodOn(ItemController.class).all()).withSelfRel());
    }

    @GetMapping("/items/{id}")
    EntityModel<Item> one(@PathVariable Long id) {

        Item item = itemRepository.findById(id) //
                .orElseThrow(() -> new ItemNotFoundException(id));

        return assembler.toModel(item);
    }

    @PostMapping("/items")
    ResponseEntity<EntityModel<Item>> newItem(@RequestBody Item item) {
        Item newItem = itemRepository.save(item);

        return ResponseEntity //
                .created(linkTo(methodOn(OrderController.class).one(newItem.getID())).toUri()) //
                .body(assembler.toModel(newItem));
    }

    @DeleteMapping("/items/{id}/del")
    ResponseEntity<?> delete(@PathVariable Long id) {

        Item item = itemRepository.findById(id) //
                .orElseThrow(() -> new ItemNotFoundException(id));

        return ResponseEntity //
                .status(HttpStatus.METHOD_NOT_ALLOWED) //
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE) //
                .body(Problem.create() //
                        .withTitle("Method not allowed"));
    }







}
