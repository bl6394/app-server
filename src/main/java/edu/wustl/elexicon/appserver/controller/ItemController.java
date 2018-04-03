package edu.wustl.elexicon.appserver.controller;

import edu.wustl.elexicon.appserver.domain.Item;
import edu.wustl.elexicon.appserver.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@RestController
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/item/{wid}")
    public Item item(@PathVariable @NotNull @DecimalMin("0") Long wid){
        System.out.println("Wid:" +  wid);
        return itemRepository.getOne(wid);
    }
}
