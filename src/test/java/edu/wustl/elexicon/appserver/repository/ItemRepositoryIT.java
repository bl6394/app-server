package edu.wustl.elexicon.appserver.repository;

import edu.wustl.elexicon.appserver.AppServerApplication;
import edu.wustl.elexicon.appserver.domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppServerApplication.class)
public class ItemRepositoryIT {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        Item item = itemRepository.save(new Item("test"));
        Optional<Item> foundItem = itemRepository.findById(item.getWid());

        assertNotNull(foundItem);
        assertEquals(item, foundItem.get());
    }


}