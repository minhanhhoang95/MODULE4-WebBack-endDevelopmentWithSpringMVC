package com.cg.cms.service;

import com.cg.cms.model.Customer;

public interface ICustomerService extends IGeneralService<Customer>{
    boolean insertWithStoredProcedure(Customer customer);
}
