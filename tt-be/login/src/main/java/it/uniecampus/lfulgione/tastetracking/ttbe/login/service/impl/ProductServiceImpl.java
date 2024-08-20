package it.uniecampus.lfulgione.tastetracking.ttbe.login.service.impl;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.entity.ProductEntity;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.mapper.ProductMapper;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.repository.ProductRepository;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public void create(ProductDTO productDTO) {
        log.info("START PRODUCT.create");
        productDTO.setName(productDTO.getName().toUpperCase().trim());
        ProductEntity productEntity = productMapper.entity(productDTO);
        log.info("{}", productEntity);
        productRepository.save(productEntity);
        log.info("END PRODUCT.create");
    }

    @Override
    public List<ProductDTO> search(String name, Integer type) {
        log.info("START PRODUCT.search");
        List<ProductEntity> productEntities;
        if (Strings.isBlank(name)) {
            if (type != null) {
                productEntities = productRepository.findByTypeAndDeleteDateIsNull(type);
            } else {
                productEntities = productRepository.findByDeleteDateIsNull();
            }
        } else {
            name = name.trim();
            if (type != null) {
                productEntities = productRepository.findByNameContainsIgnoreCaseAndTypeAndDeleteDateIsNull(name, type);
            } else {
                productEntities = productRepository.findByNameContainsIgnoreCaseAndDeleteDateIsNull(name);
            }
        }
        log.info("Entities:\n{}", productEntities);
        List<ProductDTO> dtos = productMapper.dto(productEntities);
        log.info("END PRODUCT.search");
        return dtos;
    }
}
