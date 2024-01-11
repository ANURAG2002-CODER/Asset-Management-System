package com.example.Asset_Management_System.Repository;

import com.example.Asset_Management_System.Model.AssetCatagory;
import com.example.Asset_Management_System.Model.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Assets,Integer> {
    List<Assets> findByName(String assetName);
}
