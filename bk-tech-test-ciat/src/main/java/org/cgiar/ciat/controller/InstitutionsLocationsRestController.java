package org.cgiar.ciat.controller;

import org.cgiar.ciat.domain.*;
import org.cgiar.ciat.dto.InstitutionsLocationsDTO;
import org.cgiar.ciat.mapper.InstitutionsLocationsMapper;
import org.cgiar.ciat.service.InstitutionsLocationsService;

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
@RequestMapping("/api/institutionsLocations")
@CrossOrigin(origins = "*")
public class InstitutionsLocationsRestController {
    private static final Logger log = LoggerFactory.getLogger(InstitutionsLocationsRestController.class);
    @Autowired
    private InstitutionsLocationsService institutionsLocationsService;
    @Autowired
    private InstitutionsLocationsMapper institutionsLocationsMapper;

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")
    Long id) {
        log.debug("Request to findById() InstitutionsLocations");

        try {
            InstitutionsLocations institutionsLocations = institutionsLocationsService.findById(id)
                                                                                      .get();

            return ResponseEntity.ok()
                                 .body(institutionsLocationsMapper.institutionsLocationsToInstitutionsLocationsDTO(
                    institutionsLocations));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() InstitutionsLocations");

        try {
            return ResponseEntity.ok()
                                 .body(institutionsLocationsMapper.listInstitutionsLocationsToListInstitutionsLocationsDTO(
                    institutionsLocationsService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(
        @RequestBody
    InstitutionsLocationsDTO institutionsLocationsDTO) {
        log.debug("Request to save InstitutionsLocations: {}",
            institutionsLocationsDTO);

        try {
            InstitutionsLocations institutionsLocations = institutionsLocationsMapper.institutionsLocationsDTOToInstitutionsLocations(institutionsLocationsDTO);
            institutionsLocations = institutionsLocationsService.save(institutionsLocations);

            return ResponseEntity.ok()
                                 .body(institutionsLocationsMapper.institutionsLocationsToInstitutionsLocationsDTO(
                    institutionsLocations));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(
        @RequestBody
    InstitutionsLocationsDTO institutionsLocationsDTO) {
        log.debug("Request to update InstitutionsLocations: {}",
            institutionsLocationsDTO);

        try {
            InstitutionsLocations institutionsLocations = institutionsLocationsMapper.institutionsLocationsDTOToInstitutionsLocations(institutionsLocationsDTO);
            institutionsLocations = institutionsLocationsService.update(institutionsLocations);

            return ResponseEntity.ok()
                                 .body(institutionsLocationsMapper.institutionsLocationsToInstitutionsLocationsDTO(
                    institutionsLocations));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")
    Long id) throws Exception {
        log.debug("Request to delete InstitutionsLocations");

        try {
            InstitutionsLocations institutionsLocations = institutionsLocationsService.findById(id)
                                                                                      .get();

            institutionsLocationsService.delete(institutionsLocations);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(institutionsLocationsService.count());
    }
}
