package com.springboot.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.springboot.test.data.repos.CustomerContactRepository;
import com.springboot.test.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class ContactsManagementServiceTest {
  @Mock
  CustomerContactRepository customerContactRepository;

  @InjectMocks
  private ContactsManagementService contactsManagementService;

  @Test
  public void testAddContactHappyPath() {
    // Create a contact
    CustomerContact aMockContact = new CustomerContact();
    aMockContact.setFirstName("Jenny");
    aMockContact.setLastName("Johnson");

    when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aMockContact);

    // Test adding the contact
    CustomerContact customerContact = contactsManagementService.add(aMockContact);

    // Verify the addition
    assertNotNull(customerContact);
    assertNotNull(customerContact.getId());
    assertEquals("Jenny", customerContact.getFirstName());

  }
}
