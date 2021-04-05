package com.mymoneyisgone.data;

import com.mymoneyisgone.models.ProductType;
import org.springframework.data.repository.CrudRepository;

public interface ProductTypeRepository extends CrudRepository <ProductType, Long> {
}
