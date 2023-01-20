package com.springbootacadamy.POS.dto.paginated;

import com.springbootacadamy.POS.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    private List<ItemDTO> list;
    private long dataCount;
}
