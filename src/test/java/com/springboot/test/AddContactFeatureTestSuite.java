package com.springboot.test;


import com.springboot.test.controller.ContactsManagementControllerIntegrationTest;
import com.springboot.test.data.repos.CustomerContactRepositoryIntegrationTest;
import com.springboot.test.service.ContactsManagementServiceIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( {ContactsManagementServiceIntegrationTest.class,
    ContactsManagementControllerIntegrationTest.class,
    CustomerContactRepositoryIntegrationTest.class})
public class AddContactFeatureTestSuite {
}
