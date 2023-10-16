package com.simplon.dvdstore.cart.controller.dto;

import com.simplon.dvdstore.cart.repository.PanierRepositoryModel;
import com.simplon.dvdstore.cart.service.PanierServiceModel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PanierDtoMapper {
    PanierDtoMapper INSTANCE = Mappers.getMapper(PanierDtoMapper.class);

    /* POST ET PUT --->  ---> */
    PanierServiceModel toService(PanierDto panierDto);


    /* <--- <--- GET ALL et GET ONE */
    @Mapping(source = "paniers", target="dvds")
    PanierDto toDto(PanierServiceModel panierServiceModel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PanierServiceModel partialUpdate(PanierDto panierDto, @MappingTarget PanierServiceModel panierServiceModel);
}
