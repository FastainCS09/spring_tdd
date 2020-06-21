package com.springboot.test.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.test.domain.CustomerContact;
import com.springboot.test.service.ContactsManagementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsManagementController.class)
public class ContactsManagementControllerUnitTest {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  ContactsManagementService contactsManagementService;

  @InjectMocks
  ContactsManagementController contactsManagementController;

  @Before
  public void setUp(){
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testAddContactHappyPath() throws Exception {
    // Create a contact
    CustomerContact aContact = new CustomerContact();
    aContact.setFirstName("Jenny");
    aContact.setLastName("Johnson");

    when(contactsManagementService.add(any(CustomerContact.class))).thenReturn(aContact);

    CustomerContact customerContact = new CustomerContact();
    customerContact.setFirstName("Shark");
    customerContact.setLastName("Johnson");

    String customer =(new ObjectMapper()).valueToTree(customerContact).toString();

    mockMvc.perform(post("/addContact")
        .content(customer)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn();
  }
}
