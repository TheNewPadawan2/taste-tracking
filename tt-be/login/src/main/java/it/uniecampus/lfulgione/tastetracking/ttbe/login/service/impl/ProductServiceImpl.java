package it.uniecampus.lfulgione.tastetracking.ttbe.login.service.impl;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.service.ProductService;
import jdk.jshell.spi.ExecutionControl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Override
    public void create(ProductDTO productDTO) {
        log.info("START PRODUCT.create");
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
