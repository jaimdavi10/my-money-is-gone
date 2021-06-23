package com.mymoneyisgone.data;

import com.mymoneyisgone.models.ProductType;
import com.mymoneyisgone.models.PurchaseEntry;
import com.mymoneyisgone.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface PurchaseEntryRepository extends CrudRepository<PurchaseEntry,Long> {

        @Query("FROM PurchaseEntry WHERE productType.name = :productTypeName AND user = :user")
        List<PurchaseEntry> findAllByProductType (@Param("productTypeName") String productTypeName, @Param("user") User user) ;


        //Set<PurchaseEntry> findAllByProductTypeIgnoreCase (ProductType productType) ;

}
