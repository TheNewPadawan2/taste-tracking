package it.uniecampus.lfulgione.tastetracking.ttbe.login.service.impl;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.entity.ProductEntity;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.mapper.ProductMapper;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.repository.ProductRepository;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.service.ProductService;
import jdk.jshell.spi.ExecutionControl;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
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
        ProductEntity productEntity = productMapper.entity(productDTO);
        log.info("{}", productEntity);
        productRepository.save(productEntity);
        log.info("END PRODUCT.create");
    }

    @Override
    @SneakyThrows
    public List<ProductDTO> search(String name, Integer type) {
        log.info("START PRODUCT.search");
        throw new ExecutionControl.NotImplementedException("Product search method");
//        log.info("END PRODUCT.search");
    }
}
