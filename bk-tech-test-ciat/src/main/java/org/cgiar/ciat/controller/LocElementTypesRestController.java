package org.cgiar.ciat.controller;

import org.cgiar.ciat.domain.*;
import org.cgiar.ciat.dto.LocElementTypesDTO;
import org.cgiar.ciat.mapper.LocElementTypesMapper;
import org.cgiar.ciat.service.LocElementTypesService;

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
@RequestMapping("/api/locElementTypes")
@CrossOrigin(origins = "*")
public class LocElementTypesRestController {
    private static final Logger log = LoggerFactory.getLogger(LocElementTypesRestController.class);
    @Autowired
    private LocElementTypesService locElementTypesService;
    @Autowired
    private LocElementTypesMapper locElementTypesMapper;

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")
    Long id) {
        log.debug("Request to findById() LocElementTypes");

        try {
            LocElementTypes locElementTypes = locElementTypesService.findById(id)
                                                                    .get();

            return ResponseEntity.ok()
                                 .body(locElementTypesMapper.locElementTypesToLocElementTypesDTO(
                    locElementTypes));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() LocElementTypes");

        try {
            return ResponseEntity.ok()
                                 .body(locElementTypesMapper.listLocElementTypesToListLocElementTypesDTO(
                    locElementTypesService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(
        @RequestBody
    LocElementTypesDTO locElementTypesDTO) {
        log.debug("Request to save LocElementTypes: {}", locElementTypesDTO);

        try {
            LocElementTypes locElementTypes = locElementTypesMapper.locElementTypesDTOToLocElementTypes(locElementTypesDTO);
            locElementTypes = locElementTypesService.save(locElementTypes);

            return ResponseEntity.ok()
                                 .body(locElementTypesMapper.locElementTypesToLocElementTypesDTO(
                    locElementTypes));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(
        @RequestBody
    LocElementTypesDTO locElementTypesDTO) {
        log.debug("Request to update LocElementTypes: {}", locElementTypesDTO);

        try {
            LocElementTypes locElementTypes = locElementTypesMapper.locElementTypesDTOToLocElementTypes(locElementTypesDTO);
            locElementTypes = locElementTypesService.update(locElementTypes);

            return ResponseEntity.ok()
                                 .body(locElementTypesMapper.locElementTypesToLocElementTypesDTO(
                    locElementTypes));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")
    Long id) throws Exception {
        log.debug("Request to delete LocElementTypes");

        try {
            LocElementTypes locElementTypes = locElementTypesService.findById(id)
                                                                    .get();

            locElementTypesService.delete(locElementTypes);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(locElementTypesService.count());
    }
}
