package com.ra.session08;

import com.ra.session08.model.entity.Category;

public class Main {
    public static void main(String[] args) {
        Category category = Category
                .builder()
                .id(1L)
                .cateName("Đồ gia dụng")
                .description("ngon bổ rẻ")
                .status(true)
                .build();
    }
}
