package com.springboot.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.springboot.test.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactsManagementControllerIntegrationTest {

  @Autowired
  private ContactsManagementController contactsManagementController;

  @Test
  public void testAddContactHappyPath() {
    // Create a contact
    CustomerContact aContact = new CustomerContact();
    aContact.setFirstName("Jenny");
    aContact.setLastName("Johnson");

    //POST Contact bean to the controller
    String outcome = contactsManagementController.processAddContactSubmit(aContact);

    // Verify the addition
    assertEquals("success", outcome);
  }
}
