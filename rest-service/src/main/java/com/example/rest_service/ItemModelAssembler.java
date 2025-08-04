package com.example.rest_service;

import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class ItemModelAssembler {
    public EntityModel<Item> toModel(Item item) {

        // Unconditional links to single-item resource and aggregate root

        EntityModel<Item> itemModel = EntityModel.of(item,
                linkTo(methodOn(ItemController.class).one(item.getID())).withSelfRel(),
                linkTo(methodOn(ItemController.class).all()).withRel("items"));



        return itemModel;
    }


}
