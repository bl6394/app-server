package edu.wustl.elexicon.appserver.controller;

import edu.wustl.elexicon.appserver.domain.Item;
import edu.wustl.elexicon.appserver.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/item/{wid}")
    public Item item(@PathVariable @NotNull @DecimalMin("0") Long wid){
        return itemRepository.getOne(wid);
    }

    @RequestMapping("/item")
    public List<Item> getItems(){
        return itemRepository.findAll();
    }
}
