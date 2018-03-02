package com.cop.integrationTest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/daos.xml", "/services.xml", "/misc-beans.xml", "/datasource-test.xml" })
@Transactional
public class UserIntegrationTests {


}
