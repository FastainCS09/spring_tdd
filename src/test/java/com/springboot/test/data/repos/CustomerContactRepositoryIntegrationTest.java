package com.springboot.test.data.repos;

import static org.junit.Assert.assertEquals;

import com.springboot.test.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
public class CustomerContactRepositoryIntegrationTest {

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private CustomerContactRepository customerContactRepository;

  @Test
  public void testFindByName(){
    // Create a contact
    CustomerContact aContact = new CustomerContact();
    aContact.setFirstName("Jenny");
    aContact.setLastName("Johnson");

    testEntityManager.persist(aContact);

    CustomerContact foundCustomerContact = customerContactRepository.findByFirstName(aContact.getFirstName());

    assertEquals(foundCustomerContact.getFirstName(), "Jenny");
  }
}
