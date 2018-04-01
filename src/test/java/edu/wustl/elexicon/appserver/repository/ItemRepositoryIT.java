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
        Optional<Item> foundItem = itemRepository.findById(1L);
        assertNotNull(foundItem);
        assertEquals("a", foundItem.get().getWord());
    }


}