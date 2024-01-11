package com.example.Asset_Management_System.Service;

import com.example.Asset_Management_System.Model.Assets;
import com.example.Asset_Management_System.Model.AssignmentStatus;
import com.example.Asset_Management_System.Repository.AssetCatagoryRepository;
import com.example.Asset_Management_System.Repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private AssetCatagoryRepository catagoryRepository;

    public List<Assets> getAllAssets(){
        return assetRepository.findAll();
    }

    public Optional<Assets> getAssetById(int id){
        return assetRepository.findById(id);
    }

    public Assets addAsset(Assets asset){
        return assetRepository.save(asset);
    }

    public void updateAsset(int id, Assets updatedAsset){
        assetRepository.findById(id).ifPresent(asset -> {
            asset.setAssetName(updatedAsset.getAssetName());
            asset.setPurchaseDate(updatedAsset.getPurchaseDate());
            asset.setConditionNotes(updatedAsset.getConditionNotes());
            asset.setCatagory(updatedAsset.getCatagory());
            asset.setAssignmentStatus(updatedAsset.getAssignmentStatus());
            assetRepository.save(asset);
        });
    }


    public void recoverAsset(int assetId){
        assetRepository.findById(assetId).ifPresent(asset->{
            asset.setAssignmentStatus(AssignmentStatus.Recovered);
            assetRepository.save(asset);
        });
    }

    public void deleteAsset(int id){
        assetRepository.findById(id).ifPresent(asset ->{
            if(asset.getAssignmentStatus() !=AssignmentStatus.Assigned){
                assetRepository.deleteById(id);
            }
            else{
                throw new RuntimeException("Cannot delete an assigned asset");
            }
        });
    }

    public List<Assets> searchAssets(String assetName){
        return assetRepository.findByName(assetName);
    }
}
