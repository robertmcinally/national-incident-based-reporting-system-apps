package org.jmresler.fbi.nibrs.controllers;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.fbi.nibrs.Agencies;
import org.jmresler.fbi.nibrs.services.AgenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping( path = AgenciesController.PATH)
public class AgenciesController {

    public static final String PATH = "/agencies";

    @Autowired
    protected AgenciesService agenciesService;


    private static final Agencies EMPTY_AGENCY = new Agencies(){{}};


    @GetMapping("/{id}")
    public ResponseEntity<Agencies> findAgenciesById(@PathVariable("id") Long id) {
        var agency = agenciesService.getAgenciesById(id);
        log.debug("Controller, Agency -> {}", agency);
        return ResponseEntity.ok(agency);
    }
}
