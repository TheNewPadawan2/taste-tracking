package it.uniecampus.lfulgione.tastetracking.ttbe.login.mapper;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductType;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    @Mapping(source = "type", target = "type", qualifiedByName = "integer-producttype")
    ProductDTO dto(ProductEntity entity);

    @Mapping(target = "type", expression = "java(dto.getType().ordinal())")
    ProductEntity entity(ProductDTO dto);

    default List<ProductDTO> dto(List<ProductEntity> entities) {
        if (entities == null) return new ArrayList<>();
        List<ProductDTO> dtos = new ArrayList<>(entities.size());
        for (ProductEntity entity : entities) dtos.add(dto(entity));
        return dtos;
    }

    @Named(value = "integer-producttype")
    default ProductType productType(Integer index) {
        if (index == null || index < 0) return null;
        return ProductType.values()[index];
    }
}
