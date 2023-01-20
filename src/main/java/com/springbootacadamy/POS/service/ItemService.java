package com.springbootacadamy.POS.service;

import com.springbootacadamy.POS.dto.ItemDTO;
import com.springbootacadamy.POS.dto.paginated.PaginatedResponseItemDTO;
import com.springbootacadamy.POS.dto.request.RequestItemSaveDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ItemService {
    String addItem(RequestItemSaveDTO requestItemSaveDTO);

    List<ItemDTO> getItemByNameAndActiveState(String itemName) ;

    PaginatedResponseItemDTO getAllItemsActive(int page, int size, boolean activeStatus);
}
