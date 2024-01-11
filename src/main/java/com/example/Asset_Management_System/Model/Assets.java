package com.example.Asset_Management_System.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Assets")
public class Assets {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @Column(name="assetName")
    private String name;

    @Column(name="purchaseDate")
    private Date purchaseDate;

    @Column(name="conditionNotes")
    private String conditionNotes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="catagoryId")
    private AssetCatagory assetCatagory;

    @Enumerated(EnumType.STRING)
    @Column(name="assignmentStatus")
    private AssignmentStatus assignmentStatus;

    public String getAssetName(){
        return name;
    }

    public void setAssetName(String assetName){
        this.name=assetName;
    }

    public Date getPurchaseDate(){
        return purchaseDate;
    }

    public void setPurchaseDate(Date date){
        this.purchaseDate=date;
    }

    public String getConditionNotes(){
        return conditionNotes;
    }

    public void setConditionNotes(String conditionNotes){
        this.conditionNotes=conditionNotes;
    }

    public AssetCatagory getCatagory(){
        return this.assetCatagory;
    }

    public void setCatagory(AssetCatagory updatedCatagory){
        this.assetCatagory=updatedCatagory;
    }
    public AssignmentStatus getAssignmentStatus(){
        return this.assignmentStatus;
    }

    public void setAssignmentStatus(AssignmentStatus updatedStatus){
        this.assignmentStatus=updatedStatus;
    }
}

