package com.example.Asset_Management_System.Service;

import com.example.Asset_Management_System.Model.AssetCatagory;
import com.example.Asset_Management_System.Repository.AssetCatagoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AssetCatagoryService {
    @Autowired
    private AssetCatagoryRepository catagoryRepository;

    public List<AssetCatagory> getAllCatagories(){
        return catagoryRepository.findAll();
    }

    public Optional<AssetCatagory> getCatagoryById(int id){
        return catagoryRepository.findById(id);
    }

    public AssetCatagory addCatagory(AssetCatagory catagory){
        return catagoryRepository.save(catagory);
    }

    public void updateCatagory(int id, AssetCatagory updatedCatagory){
        catagoryRepository.findById(id).ifPresent(catagory -> {
            catagory.setName(updatedCatagory.getName());
            catagory.setDescription(updatedCatagory.getDescription());
            catagoryRepository.save(catagory);
        });
    }

    public void deleteCatagory(int id){
        catagoryRepository.deleteById(id);
    }
}
