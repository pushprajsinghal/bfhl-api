package com.bfhl.api.controller;

import com.bfhl.api.dto.BfhlRequest;
import com.bfhl.api.dto.BfhlResponse;
import com.bfhl.api.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/bfhl")
@CrossOrigin(origins = "*")
public class BfhlController {

    private final BfhlService bfhlService;

    @Autowired
    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping
    public ResponseEntity<BfhlResponse> processData(@RequestBody(required = false) BfhlRequest request) {
        try {
            BfhlResponse response = bfhlService.processRequest(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            BfhlResponse errorResponse = new BfhlResponse();
            errorResponse.setSuccess(false);
            return ResponseEntity.ok(errorResponse);
        }
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of("status", "OK", "service", "bfhl-api"));
    }
}
