package com.mymoneyisgone.service;

import com.mymoneyisgone.data.PurchaseEntryRepository;
import com.mymoneyisgone.models.ProductType;
import com.mymoneyisgone.models.PurchaseEntry;
import com.mymoneyisgone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PurchaseEntryService {

    private PurchaseEntryRepository per;

    @Autowired
    public PurchaseEntryService (PurchaseEntryRepository per) {
        this.per = per;
    }

    public Iterable<PurchaseEntry> purchaseEntries (User user) {
        return user.getPurchaseEntrySet();
    }

    public List<PurchaseEntry> byProductType (String productTypeName, User user) {
        return per.findAllByProductType(productTypeName, user);
    }
}
