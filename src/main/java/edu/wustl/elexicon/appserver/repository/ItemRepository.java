package edu.wustl.elexicon.appserver.repository;

import edu.wustl.elexicon.appserver.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

    Page<Item> findAll(Pageable pageable);

}
