package com.example.Asset_Management_System.Controller;

import com.example.Asset_Management_System.Model.AssetCatagory;
import com.example.Asset_Management_System.Service.AssetCatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/catagory")
public class AssetCatagoryController {
    @Autowired
    private AssetCatagoryService catagoryService;

    @GetMapping("")
    public ResponseEntity<List<AssetCatagory>> getAllCatagories(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                @RequestParam(defaultValue = "10") Integer pageSize){
        List<AssetCatagory> catagories=catagoryService.getAllCatagories(pageNo,pageSize);
        return new ResponseEntity<>(catagories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetCatagory> getCatagoryById(@PathVariable int id){
        Optional<AssetCatagory> catagory=catagoryService.getCatagoryById(id);
        return catagory.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<AssetCatagory> addCatagory(@RequestBody AssetCatagory catagory){
        AssetCatagory savedCatagory=catagoryService.addCatagory(catagory);
        return new ResponseEntity<>(savedCatagory,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> deleteCatagory(@PathVariable int id){
        catagoryService.deleteCatagory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
