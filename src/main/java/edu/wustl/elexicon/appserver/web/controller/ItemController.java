package edu.wustl.elexicon.appserver.web.controller;

import edu.wustl.elexicon.appserver.web.exception.ResourceNotFoundException;
import edu.wustl.elexicon.appserver.web.hateos.event.PaginatedResultsRetrievedEvent;
import edu.wustl.elexicon.appserver.domain.Item;
import edu.wustl.elexicon.appserver.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Controller
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @RequestMapping("/item/{wid}")
    @ResponseBody
    public Item item(@PathVariable @NotNull @DecimalMin("0") Long wid){
        Optional<Item> byId = itemRepository.findById(wid);
        if (byId.isPresent()){
            return byId.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(path="/item", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> findPaginated(@RequestParam(value = "page", required = false, defaultValue = "0") final Integer page, @RequestParam(value = "size", required = false, defaultValue = "10") final Integer size, final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
        PageRequest pageRequest = PageRequest.of(page, size);
        final Page<Item> resultPage = itemRepository.findAll(pageRequest);
        if (page > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException();
        }
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<Item>(Item.class, uriBuilder, response, page, resultPage.getTotalPages(), size));

        return resultPage.getContent();
    }
}
