package org.cgiar.ciat.controller;

import org.cgiar.ciat.domain.*;
import org.cgiar.ciat.dto.InstitutionTypesDTO;
import org.cgiar.ciat.mapper.InstitutionTypesMapper;
import org.cgiar.ciat.service.InstitutionTypesService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/institutionTypes")
@CrossOrigin(origins = "*")
public class InstitutionTypesRestController {
    private static final Logger log = LoggerFactory.getLogger(InstitutionTypesRestController.class);
    @Autowired
    private InstitutionTypesService institutionTypesService;
    @Autowired
    private InstitutionTypesMapper institutionTypesMapper;

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")
    Long id) {
        log.debug("Request to findById() InstitutionTypes");

        try {
            InstitutionTypes institutionTypes = institutionTypesService.findById(id)
                                                                       .get();

            return ResponseEntity.ok()
                                 .body(institutionTypesMapper.institutionTypesToInstitutionTypesDTO(
                    institutionTypes));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() InstitutionTypes");

        try {
            return ResponseEntity.ok()
                                 .body(institutionTypesMapper.listInstitutionTypesToListInstitutionTypesDTO(
                    institutionTypesService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(
        @RequestBody
    InstitutionTypesDTO institutionTypesDTO) {
        log.debug("Request to save InstitutionTypes: {}", institutionTypesDTO);

        try {
            InstitutionTypes institutionTypes = institutionTypesMapper.institutionTypesDTOToInstitutionTypes(institutionTypesDTO);
            institutionTypes = institutionTypesService.save(institutionTypes);

            return ResponseEntity.ok()
                                 .body(institutionTypesMapper.institutionTypesToInstitutionTypesDTO(
                    institutionTypes));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(
        @RequestBody
    InstitutionTypesDTO institutionTypesDTO) {
        log.debug("Request to update InstitutionTypes: {}", institutionTypesDTO);

        try {
            InstitutionTypes institutionTypes = institutionTypesMapper.institutionTypesDTOToInstitutionTypes(institutionTypesDTO);
            institutionTypes = institutionTypesService.update(institutionTypes);

            return ResponseEntity.ok()
                                 .body(institutionTypesMapper.institutionTypesToInstitutionTypesDTO(
                    institutionTypes));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")
    Long id) throws Exception {
        log.debug("Request to delete InstitutionTypes");

        try {
            InstitutionTypes institutionTypes = institutionTypesService.findById(id)
                                                                       .get();

            institutionTypesService.delete(institutionTypes);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(institutionTypesService.count());
    }
}
