package com.example.latihanjava.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.latihanjava.exeption.ResourceNotFoundException;
import com.example.latihanjava.model.Kategori;
import com.example.latihanjava.repository.KategoriRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/kategori")
public class KategoriController {
    
    @Autowired
    KategoriRepository kategoriRepository;

    @GetMapping(value="/")
    public List<Kategori> getAllNotes() {
        return kategoriRepository.findAll();
    }
    
    @PostMapping(value="/")
    public Kategori createKategori(@Valid @RequestBody Kategori kategori) {
        return kategoriRepository.save(kategori);
    }

    @GetMapping("/{id}")
    public Kategori getKategoriById(@PathVariable(value = "id") Long kategoriId){
        return kategoriRepository.findById(kategoriId).orElseThrow( () -> new ResourceNotFoundException("Kategori", "id", kategoriId));
    }

    @PutMapping("/{id}")
    public Kategori updateKategori(@PathVariable(value = "id") Long kategoriId, @Valid @RequestBody Kategori kategoriDetails) {
        Kategori kategori = kategoriRepository.findById(kategoriId).orElseThrow(() -> new ResourceNotFoundException("Kategori", "id", kategoriId));

        kategori.setKategori(kategoriDetails.getKategori());

        Kategori updateKategori = kategoriRepository.save(kategori);
        return updateKategori;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKategori(@PathVariable(value = "id") Long kategoriId) {
        Kategori kategori = kategoriRepository.findById(kategoriId).orElseThrow(() -> new ResourceNotFoundException("Kategori", "id", kategoriId));

        kategoriRepository.delete(kategori);

        return ResponseEntity.ok().build();
    }

    

    
}