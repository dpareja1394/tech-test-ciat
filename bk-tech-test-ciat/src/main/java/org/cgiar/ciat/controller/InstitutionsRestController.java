package org.cgiar.ciat.controller;

import org.cgiar.ciat.domain.*;
import org.cgiar.ciat.dto.InstitutionsDTO;
import org.cgiar.ciat.mapper.InstitutionsMapper;
import org.cgiar.ciat.service.InstitutionsService;

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
@RequestMapping("/api/institutions")
@CrossOrigin(origins = "*")
public class InstitutionsRestController {
    private static final Logger log = LoggerFactory.getLogger(InstitutionsRestController.class);
    @Autowired
    private InstitutionsService institutionsService;
    @Autowired
    private InstitutionsMapper institutionsMapper;

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")
    Long id) {
        log.debug("Request to findById() Institutions");

        try {
            Institutions institutions = institutionsService.findById(id).get();

            return ResponseEntity.ok()
                                 .body(institutionsMapper.institutionsToInstitutionsDTO(
                    institutions));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() Institutions");

        try {
            return ResponseEntity.ok()
                                 .body(institutionsMapper.listInstitutionsToListInstitutionsDTO(
                    institutionsService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody
    InstitutionsDTO institutionsDTO) {
        log.debug("Request to save Institutions: {}", institutionsDTO);

        try {
            Institutions institutions = institutionsMapper.institutionsDTOToInstitutions(institutionsDTO);
            institutions = institutionsService.save(institutions);

            return ResponseEntity.ok()
                                 .body(institutionsMapper.institutionsToInstitutionsDTO(
                    institutions));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    InstitutionsDTO institutionsDTO) {
        log.debug("Request to update Institutions: {}", institutionsDTO);

        try {
            Institutions institutions = institutionsMapper.institutionsDTOToInstitutions(institutionsDTO);
            institutions = institutionsService.update(institutions);

            return ResponseEntity.ok()
                                 .body(institutionsMapper.institutionsToInstitutionsDTO(
                    institutions));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")
    Long id) throws Exception {
        log.debug("Request to delete Institutions");

        try {
            Institutions institutions = institutionsService.findById(id).get();

            institutionsService.delete(institutions);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(institutionsService.count());
    }
}
