package com.example.name;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
@Validated
public class NameController {
    private final NameService nameService;
    private final NameMapper nameMapper;

    public NameController(NameService nameService, NameMapper nameMapper) {
        this.nameService = nameService;
        this.nameMapper = nameMapper;
    }

    @GetMapping("/names/{id}")
    public ResponseEntity<?> getName(@PathVariable("id") int id) {
        try {

            Name name = nameService.findById(id);
            return new ResponseEntity<>(name, HttpStatus.OK);
        } catch (NameNotFoundException e) {

            Map<String, String> body = Map.of(
                    "timestamp", ZonedDateTime.now().toString(),
                    "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                    "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                    "message", e.getMessage());
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
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

    @ExceptionHandler(value = NameNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNameNotFoundException(
            NameNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Name> updateName(
            @PathVariable("id") int id,
            @RequestBody NameRequest nameRequest) {

        Name existingName = nameService.findById(id);

        Name updatedName = nameService.update(existingName, nameRequest.getName(), nameRequest.getAge());
        return new ResponseEntity<>(updatedName, HttpStatus.OK);
    }
}
