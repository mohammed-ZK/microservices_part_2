package com.example.shopping_cart.mapper;

import org.mapstruct.Mapper;

import com.example.shopping_cart.dto.CartDto;
import com.example.shopping_cart.entity.Cart;

@Mapper
public interface CartMapper {

	CartDto mapToDto(Cart cart);

	Cart mapToEntity(CartDto cartDto);

}
