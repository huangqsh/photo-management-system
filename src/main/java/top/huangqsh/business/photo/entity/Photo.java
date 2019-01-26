package top.huangqsh.business.photo.entity;

import top.huangqsh.core.base.BaseEntity;

import javax.persistence.Table;

@Table(name = "tab_photo")
public class Photo extends BaseEntity {
    // name
    private String photoName;
    // 图片地址
    private String fileURL;

    // 介绍
    private String info;
    //品牌
    private String camera;
    // 感光度
    private String ISO;
    // 快门
    private String shutter;
    // 光圈
    private String Aperture;

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getISO() {
        return ISO;
    }

    public void setISO(String ISO) {
        this.ISO = ISO;
    }

    public String getShutter() {
        return shutter;
    }

    public void setShutter(String shutter) {
        this.shutter = shutter;
    }

    public String getAperture() {
        return Aperture;
    }

    public void setAperture(String aperture) {
        Aperture = aperture;
    }
}
