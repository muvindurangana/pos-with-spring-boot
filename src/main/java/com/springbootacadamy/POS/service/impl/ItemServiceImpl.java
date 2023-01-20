package com.springbootacadamy.POS.service.impl;

import com.springbootacadamy.POS.dto.ItemDTO;
import com.springbootacadamy.POS.dto.paginated.PaginatedResponseItemDTO;
import com.springbootacadamy.POS.dto.request.RequestItemSaveDTO;
import com.springbootacadamy.POS.entity.Item;
import com.springbootacadamy.POS.exception.NotFoundException;
import com.springbootacadamy.POS.repo.ItemRepository;
import com.springbootacadamy.POS.service.ItemService;
import com.springbootacadamy.POS.util.mapper.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public ItemMapper itemMapper;

    @Override
    public String addItem(RequestItemSaveDTO requestItemSaveDTO) {

        Item item = modelMapper.map(requestItemSaveDTO, Item.class);

        if (!itemRepository.existsById(item.getItemId())) {
            itemRepository.save(item);
            return "item saved";
        } else {
            throw new DuplicateKeyException("Item Already Exists");
        }
    }

    @Override
    public List<ItemDTO> getItemByNameAndActiveState(String itemName) {
        boolean b = true;
        List<Item> items = itemRepository.findAllByItemNameEqualsAndActiveStateEquals(itemName, b);
        //List<ItemDTO> itemDTOS = modelMapper.map(items, new TypeToken<List<ItemDTO>>() {
        // }.getType());
        if (items.size() > 0) {
            List<ItemDTO> itemDTOS = itemMapper.entityListTODtoList(items);
            return itemDTOS;

        } else {
            throw new NotFoundException("Data Is Not Available");
        }

    }

    @Override
    public PaginatedResponseItemDTO getAllItemsActive(int page, int size, boolean activeStatus) {
        Page<Item> items = itemRepository.findAllByActiveStateEquals(activeStatus, PageRequest.of(page, size));
        if (items.getSize() < 1) {
            throw new NotFoundException("No Data According to your request");
        }

        return new PaginatedResponseItemDTO(
                itemMapper.pageToList(items),
                itemRepository.countAllByActiveStateEquals(activeStatus)
        );
    }
}