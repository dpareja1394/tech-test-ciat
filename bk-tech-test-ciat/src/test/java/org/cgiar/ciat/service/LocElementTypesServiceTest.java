package org.cgiar.ciat.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@SpringBootTest
public class LocElementTypesServiceTest {
    private static final Logger log = LoggerFactory.getLogger(LocElementTypesServiceTest.class);
    @Autowired
    private LocElementTypesService locElementTypesService;

    @Test
    @DisplayName("findAll")
    public void findAll() {
        assertNotNull(locElementTypesService);
    }

    @Test
    @DisplayName("save")
    public void save() throws Exception {
        assertNotNull(locElementTypesService);
    }

    @Test
    @DisplayName("delete")
    public void delete() throws Exception {
        assertNotNull(locElementTypesService);
    }

    @Test
    @DisplayName("deleteById")
    public void deleteById() throws Exception {
        assertNotNull(locElementTypesService);
    }

    @Test
    @DisplayName("update")
    public void update() throws Exception {
        assertNotNull(locElementTypesService);
    }

    @Test
    @DisplayName("findById")
    public void findById() throws Exception {
        assertNotNull(locElementTypesService);
    }

    @Test
    @DisplayName("count")
    public void count() throws Exception {
        assertNotNull(locElementTypesService);
    }
}
