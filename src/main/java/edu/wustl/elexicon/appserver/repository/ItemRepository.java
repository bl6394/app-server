package edu.wustl.elexicon.appserver.repository;

import edu.wustl.elexicon.appserver.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
