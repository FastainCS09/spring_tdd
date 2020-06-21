package com.springboot.test.controller;

import com.springboot.test.domain.CustomerContact;
import com.springboot.test.service.ContactsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsManagementController {
  @Autowired
  private ContactsManagementService contactsManagementService;

  @PostMapping(value = "/addContact")
  @ResponseBody
  public String processAddContactSubmit(@RequestBody CustomerContact aContact) {

    CustomerContact newContact = contactsManagementService.add(aContact);

    if (null != newContact) {
      return "success";
    }

    return "failure";
  }
}
