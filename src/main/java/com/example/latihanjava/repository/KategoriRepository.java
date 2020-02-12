package com.example.latihanjava.repository;

import org.springframework.stereotype.Repository;
import com.example.latihanjava.model.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface KategoriRepository extends JpaRepository<Kategori, Long> {

    
}