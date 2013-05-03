package org.hao.bookstore.modules.goods.service;

import java.util.List;

import org.hao.bookstore.modules.goods.dto.ProductDTO;
import org.hao.bookstore.modules.goods.dto.ProductQuery;

public interface ProductService {

    List<ProductDTO> queryProducts(ProductQuery query);
}
