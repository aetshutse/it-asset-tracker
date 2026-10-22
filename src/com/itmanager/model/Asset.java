package com.itmanager.model;

public class Asset {
    private String assetTag;
    private String deviceType;
    private String modelName;
    private String status;

    public Asset(String assetTag, String deviceType, String modelName, String status) {
        this.assetTag = assetTag;
        this.deviceType = deviceType;
        this.modelName = modelName;
        this.status = status;
    }

    public String getAssetTag() { return assetTag; }
    public void setAssetTag(String assetTag) { this.assetTag = assetTag; }

    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}