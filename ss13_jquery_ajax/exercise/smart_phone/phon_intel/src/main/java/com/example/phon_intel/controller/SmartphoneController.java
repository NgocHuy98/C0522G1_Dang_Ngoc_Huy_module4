package com.example.phon_intel.controller;

import com.example.phon_intel.model.SmartPhone;
import com.example.phon_intel.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartPhoneService smartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<SmartPhone>> getAllSmartPhonePage() {
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartPhone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = smartPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SmartPhone> updateSmartPhone(@PathVariable Long id,
                                                       @RequestBody SmartPhone smartPhone) {

        SmartPhone currentSmartPhone = smartPhoneService.findById(id).get();

        if (currentSmartPhone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentSmartPhone.setModel(smartPhone.getModel());
        currentSmartPhone.setPrice(smartPhone.getPrice());
        currentSmartPhone.setProducer(smartPhone.getProducer());
        smartPhoneService.save(currentSmartPhone);

        return new ResponseEntity<>(currentSmartPhone, HttpStatus.OK);
    }

}