package it.uniecampus.lfulgione.tastetracking.ttbe.login.controller.impl;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.controller.ProductController;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductControllerImpl implements ProductController {
    @Override
    public ResponseEntity<Void> create(ProductDTO product) {
        log.info("{}", product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> search(String name, Integer type) {
        return null;
    }
}
