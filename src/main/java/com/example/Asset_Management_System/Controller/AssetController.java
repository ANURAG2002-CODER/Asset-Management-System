package com.example.Asset_Management_System.Controller;

import com.example.Asset_Management_System.Model.Assets;
import com.example.Asset_Management_System.Service.AssetCatagoryService;
import com.example.Asset_Management_System.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @GetMapping("")
    public ResponseEntity<List<Assets>> getAllAssets(@RequestParam(defaultValue = "0") Integer pageNo,
                                                     @RequestParam(defaultValue = "10") Integer pageSize){
        List<Assets> asset=assetService.getAllAssets(pageNo,pageSize);
        return new ResponseEntity<>(asset, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Assets> getAssetById(@PathVariable int id){
        Optional<Assets> asset=assetService.getAssetById(id);
        return asset.map(value->new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{assetName}")
    public ResponseEntity<Assets> findAssetByName(@PathVariable String assetName){
        List<Assets> asset=assetService.searchAssets(assetName);
        return new ResponseEntity<Assets>(HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Assets> addAsset(@RequestBody Assets asset){
        Assets savedAsset =assetService.addAsset(asset);
        return new ResponseEntity<>(savedAsset, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAsset(@PathVariable int id, @RequestBody Assets updatedAsset){
        assetService.updateAsset(id,updatedAsset);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/recover/{id}")
    public ResponseEntity<Void> recoverAsset(@PathVariable int id){
        assetService.recoverAsset(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable int id){
        assetService.deleteAsset(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
