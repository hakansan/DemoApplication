package com.example.demo.controller;

import com.example.demo.model.dto.KisiDTO;
import com.example.demo.service.KisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("kisi")
public class KisiController {

    @Autowired
    private KisiService kisiService;

    @PostMapping("/save")
    public ResponseEntity<KisiDTO> saveKisi(@RequestBody KisiDTO kisiDTO){
        return new ResponseEntity<>(kisiService.save(kisiDTO), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<KisiDTO> update(@RequestBody KisiDTO kisiDTO){
        return ResponseEntity.ok(kisiService.update(kisiDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<List<KisiDTO>> getAll(){
        return new ResponseEntity<>(kisiService.getAll(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
            kisiService.delete(id);
        return ResponseEntity.ok(id);
    }
}
