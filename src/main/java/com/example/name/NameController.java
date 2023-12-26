package com.example.name;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class NameController {
    private final NameService nameService;
    private final NameMapper nameMapper;

    public NameController(NameService nameService, NameMapper nameMapper) {
        this.nameService = nameService;
        this.nameMapper = nameMapper;
    }

    @GetMapping("/names/{id}")
    public ResponseEntity<Name> getName(@PathVariable("id") int id) throws NameNotFoundException {
        Name name = nameService.findById(id);
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @GetMapping("/names/all")
    public List<Name> getAllNames() {
        return nameMapper.findAll();
    }

    @GetMapping("/names")
    public List<Name> findByNames(@RequestParam(required = false) String startsWith) {
        if (startsWith != null && !startsWith.isEmpty()) {
            return nameMapper.findByNameStartingWith(startsWith);
        } else {
            return nameMapper.findAll();
        }
    }

    @PostMapping("/names")
    public ResponseEntity<Name> insert(@RequestBody NameRequest nameRequest) {
        Name name = nameService.insert(nameRequest.getName(), nameRequest.getAge());
        return new ResponseEntity<>(name, HttpStatus.CREATED);
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Name> updateName(
            @PathVariable("id") int id,
            @RequestBody NameRequest nameRequest) {
        Name existingName = nameService.findById(id);
        Name updatedName = nameService.update(id, nameRequest.getName(), nameRequest.getAge());
        return new ResponseEntity<>(updatedName, HttpStatus.OK);
    }
}
