package org.cgiar.ciat.controller;

import org.cgiar.ciat.domain.*;
import org.cgiar.ciat.dto.LocElementsDTO;
import org.cgiar.ciat.mapper.LocElementsMapper;
import org.cgiar.ciat.service.LocElementsService;

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
@RequestMapping("/api/locElements")
@CrossOrigin(origins = "*")
public class LocElementsRestController {
    private static final Logger log = LoggerFactory.getLogger(LocElementsRestController.class);
    @Autowired
    private LocElementsService locElementsService;
    @Autowired
    private LocElementsMapper locElementsMapper;

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")
    Long id) {
        log.debug("Request to findById() LocElements");

        try {
            LocElements locElements = locElementsService.findById(id).get();

            return ResponseEntity.ok()
                                 .body(locElementsMapper.locElementsToLocElementsDTO(
                    locElements));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() LocElements");

        try {
            return ResponseEntity.ok()
                                 .body(locElementsMapper.listLocElementsToListLocElementsDTO(
                    locElementsService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody
    LocElementsDTO locElementsDTO) {
        log.debug("Request to save LocElements: {}", locElementsDTO);

        try {
            LocElements locElements = locElementsMapper.locElementsDTOToLocElements(locElementsDTO);
            locElements = locElementsService.save(locElements);

            return ResponseEntity.ok()
                                 .body(locElementsMapper.locElementsToLocElementsDTO(
                    locElements));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    LocElementsDTO locElementsDTO) {
        log.debug("Request to update LocElements: {}", locElementsDTO);

        try {
            LocElements locElements = locElementsMapper.locElementsDTOToLocElements(locElementsDTO);
            locElements = locElementsService.update(locElements);

            return ResponseEntity.ok()
                                 .body(locElementsMapper.locElementsToLocElementsDTO(
                    locElements));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")
    Long id) throws Exception {
        log.debug("Request to delete LocElements");

        try {
            LocElements locElements = locElementsService.findById(id).get();

            locElementsService.delete(locElements);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(locElementsService.count());
    }
}
