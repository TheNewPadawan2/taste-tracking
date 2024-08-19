package it.uniecampus.lfulgione.tastetracking.ttbe.login.mapper;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductType;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(target = "type", expression = "java(dto.getType().ordinal())")
    ProductEntity entity(ProductDTO dto);

    default Integer productType(ProductType type) {
        return type.ordinal();
    }
}
