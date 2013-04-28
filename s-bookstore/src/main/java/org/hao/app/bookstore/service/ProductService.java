package org.hao.app.bookstore.service;

import java.util.List;

import org.hao.app.bookstore.dto.ProductDTO;
import org.hao.app.bookstore.dto.ProductQuery;

public interface ProductService {

    List<ProductDTO> queryProducts(ProductQuery query);
}
