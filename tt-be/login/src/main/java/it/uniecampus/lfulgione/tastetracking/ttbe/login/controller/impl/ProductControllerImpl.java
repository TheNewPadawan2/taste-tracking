package it.uniecampus.lfulgione.tastetracking.ttbe.login.controller.impl;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.controller.ProductController;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ProductUpdateDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.ProductNotFoundException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;

    @Autowired
    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<Void> create(ProductDTO product) {
        productService.create(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> search(String name, Integer type) {
        List<ProductDTO> list = productService.search(name, type);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> update(
            ProductUpdateDTO productUpdateDTO)
            throws ProductNotFoundException {
        ProductDTO dto = productService.update(productUpdateDTO);
        return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Void> logicalDelete(
            String name)
            throws ProductNotFoundException {
        productService.logicalDelete(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
