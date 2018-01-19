package com.stx.xhb.listviewcheckdelete;

/**
 * Created by 皓 on 2017/2/15.
 */

public class MerchantBean {

    private String id ;
    private String logoPath ;
    private String merName ;
    private String intro ;
    private String merAddress ;
    private String mapLongitude;
    private String mapLatitude ;

    private String status ;

    public MerchantBean(String id, String logoPath, String merName, String intro, String merAddress, String mapLongitude, String mapLatitude, String status) {
        this.id = id;
        this.logoPath = logoPath;
        this.merName = merName;
        this.intro = intro;
        this.merAddress = merAddress;
        this.mapLongitude = mapLongitude;
        this.mapLatitude = mapLatitude;
        this.status = status;
    }
    public MerchantBean(String id, String logoPath, String merName, String intro, String merAddress, String mapLongitude, String mapLatitude) {
        this.id = id;
        this.logoPath = logoPath;
        this.merName = merName;
        this.intro = intro;
        this.merAddress = merAddress;
        this.mapLongitude = mapLongitude;
        this.mapLatitude = mapLatitude;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public MerchantBean(String id, String logoPath, String merName, String intro, String merAddress, String mapLongitude, String mapLatitude) {
//        this.id = id;
//        this.logoPath = logoPath;
//        this.merName = merName;
//        this.intro = intro;
//        this.merAddress = merAddress;
//        this.mapLongitude = mapLongitude;
//        this.mapLatitude = mapLatitude;
//    }

    public String getMerAddress() {
        return merAddress;
    }

    public void setMerAddress(String merAddress) {
        this.merAddress = merAddress;
    }

    public String getMapLongitude() {
        return mapLongitude;
    }

    public void setMapLongitude(String mapLongitude) {
        this.mapLongitude = mapLongitude;
    }

    public String getMapLatitude() {
        return mapLatitude;
    }

    public void setMapLatitude(String mapLatitude) {
        this.mapLatitude = mapLatitude;
    }

    public MerchantBean(String id, String logoPath, String merName, String intro, String status) {
        this.id = id;
        this.logoPath = logoPath;
        this.merName = merName;
        this.intro = intro;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getMerName() {
        return merName;
    }

    public void setMerName(String merName) {
        this.merName = merName;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
}
