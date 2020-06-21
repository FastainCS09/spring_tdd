package com.springboot.test.data.repos;

import org.springframework.data.repository.CrudRepository;

import com.springboot.test.domain.CustomerContact;

public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {

  CustomerContact findByFirstName(String firstName);
}
