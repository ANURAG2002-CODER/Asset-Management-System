package com.example.Asset_Management_System.Model;

import jakarta.persistence.*;

@Entity
@Table(name="AssetCatagory")
public class AssetCatagory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="catagoryId")
    private int catagoryId;

    @Column(name="catagoryName")
    private String catagoryName;


    @Column(name="catagoryDescription")
    private String catagoryDescription;

    public String getName(){
        return this.catagoryName;
    }

    public void setName(String updatedName){
        this.catagoryName=updatedName;
    }

    public String getDescription(){
        return this.catagoryDescription;
    }

    public void setDescription(String updatedDescription){
        this.catagoryDescription=updatedDescription;
    }
}
