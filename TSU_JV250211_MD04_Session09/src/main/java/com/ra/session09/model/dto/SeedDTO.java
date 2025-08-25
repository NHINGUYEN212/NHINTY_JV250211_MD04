package com.ra.session09.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SeedDTO {
    private String seedName;
    private int quantity;
    private long categoryId;
}
