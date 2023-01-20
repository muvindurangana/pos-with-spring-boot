package com.springbootacadamy.POS.controller;

import com.springbootacadamy.POS.dto.ItemDTO;
import com.springbootacadamy.POS.dto.paginated.PaginatedResponseItemDTO;
import com.springbootacadamy.POS.dto.request.RequestItemSaveDTO;
import com.springbootacadamy.POS.service.ItemService;
import com.springbootacadamy.POS.util.StandaredResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandaredResponse> saveItem(@RequestBody RequestItemSaveDTO requestItemSaveDTO) {
        String add = itemService.addItem(requestItemSaveDTO);
        return new ResponseEntity<StandaredResponse>(new StandaredResponse(201,
                "success", add), HttpStatus.OK);
    }

    @GetMapping(
            path = "/get-by-name",
            params = "names"
    )
    public List<ItemDTO> getItemByNameAndActiveState(@RequestParam(value = "names") String itemName) {
        return itemService.getItemByNameAndActiveState(itemName);

    }

    @GetMapping(
            path = "/get-by-name-1",
            params = "names"
    )
    public ResponseEntity<StandaredResponse> getItemByNameAndActiveState1(@RequestParam(value = "names") String itemName) {
        List<ItemDTO> itemDTOS = itemService.getItemByNameAndActiveState(itemName);
        // ResponseEntity<StandaredResponse> response = new ResponseEntity<StandaredResponse>( new StandaredResponse(201,
        // "success" , itemDTOS), HttpStatus.OK);

        // return response;

        return new ResponseEntity<StandaredResponse>(new StandaredResponse(201,
                "success", itemDTOS), HttpStatus.OK);
    }

    @GetMapping(
            path = {"/get-all-item-by-status"},
            params = {"page", "size", "activeStatus"}
    )
    public ResponseEntity<StandaredResponse> getAllItemsActive(@RequestParam(value = "page") int page,
                                                               @RequestParam(value = "size") @Max(50) int size,
                                                               @RequestParam(value = "activeStatus") boolean activeStatus) {
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllItemsActive(page, size, activeStatus);
        return new ResponseEntity<StandaredResponse>(new StandaredResponse(201, "success", paginatedResponseItemDTO), HttpStatus.OK);
    }
}
