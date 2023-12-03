package com.example.shopping_cart.mapper;

import org.mapstruct.Mapper;

import com.example.shopping_cart.dto.ProductDto;
import com.example.shopping_cart.entity.Product;

@Mapper
public interface ProductMapper {

	ProductDto mapToDto(Product product);

	Product mapToEntity(ProductDto productDto);

}
