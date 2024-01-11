package com.example.Asset_Management_System.Repository;

import com.example.Asset_Management_System.Model.AssetCatagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetCatagoryRepository extends JpaRepository<AssetCatagory,Integer> {
}
