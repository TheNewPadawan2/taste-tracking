package it.uniecampus.lfulgione.tastetracking.ttbe.login.service.impl;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductUpdateDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.entity.ProductEntity;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.ProductNotFoundException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.mapper.ProductMapper;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.repository.ProductRepository;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        log.info("START PRODUCT.create");
        productDTO.setName(productDTO.getName().toLowerCase().trim());
        ProductEntity productEntity = productMapper.entity(productDTO);
        log.info("{}", productEntity);
        ProductEntity entity = null;
        try {
            entity = productRepository.save(productEntity);
        } catch (Exception ex) {
            //TODO already exists (may be cancelled)
        }
        ProductDTO dto = productMapper.dto(entity);
        log.info("END PRODUCT.create");
        return dto;
    }

    @Override
    public List<ProductDTO> search(String name, Integer type) {
        log.info("START PRODUCT.search");
        List<ProductEntity> productEntities;
        if (Strings.isBlank(name)) {
            if (type != null) {
                productEntities = productRepository.findByTypeAndDeleteDateIsNullOrderByNameAsc(type);
            } else {
                productEntities = productRepository.findByDeleteDateIsNullOrderByNameAsc();
            }
        } else {
            name = name.trim();
            if (type != null) {
                productEntities = productRepository.findByNameContainsIgnoreCaseAndTypeAndDeleteDateIsNullOrderByNameAsc(name, type);
            } else {
                productEntities = productRepository.findByNameContainsIgnoreCaseAndDeleteDateIsNullOrderByNameAsc(name);
            }
        }
        log.info("Entities:\n{}", productEntities);
        List<ProductDTO> dtos = productMapper.dto(productEntities);
        log.info("END PRODUCT.search");
        return dtos;
    }

    @Override
    public ProductDTO update(
            ProductUpdateDTO productUpdateDTO)
            throws ProductNotFoundException {
        log.info("START PRODUCT.update");
        Optional<ProductEntity> productEntityOld;
        productEntityOld = productRepository.findOneByNameIgnoreCase(productUpdateDTO.getOld().getName());
        if(productEntityOld.isEmpty()) throw new ProductNotFoundException();
        productUpdateDTO.getUpdated().setName(productUpdateDTO.getUpdated().getName().toLowerCase().trim());
        ProductEntity productEntity = productMapper.entity(productUpdateDTO.getUpdated());
        ProductEntity updating = productEntityOld.get(); //NOSONAR
        updating.setName(productEntity.getName());
        updating.setType(productEntity.getType());
        ProductDTO dto = productMapper.dto(productRepository.save(updating));
        log.info("END PRODUCT.update");
        return dto;
    }

    @Override
    public void logicalDelete(
            String name)
            throws ProductNotFoundException {
        log.info("START PRODUCT.logicalDelete");
        Optional<ProductEntity> productEntityOpt;
        productEntityOpt = productRepository.findOneByNameIgnoreCase(name);
        if (productEntityOpt.isEmpty()) throw new ProductNotFoundException();
        ProductEntity productEntity = productEntityOpt.get(); //NOSONAR
        if (productEntity.getDeleteDate() == null) {
            productEntity.setDeleteDate(new Timestamp(System.currentTimeMillis()));
        }
        productRepository.save(productEntity);
        log.info("END PRODUCT.logicalDelete");
    }
}
