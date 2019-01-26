package top.huangqsh.business.photo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huangqsh.business.photo.entity.PhotoParam;
import top.huangqsh.business.photo.service.PhotoService;
import top.huangqsh.core.base.BaseResult;

import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    /**
     * 分页查询照片
     * @param gridPager
     * @return
     */
    @RequestMapping("/find/photo/page")
    public String findPhotoPage(String gridPager){

        return null;
    }

    /**
     * 添加照片（文件异步上传）
     * @param photo
     * @return
     */
    @RequestMapping("/add/photo")
    public BaseResult<String> addPhoto(PhotoParam photo){
        return null;
    }

    /**
     * 删除照片
     * @param id
     * @return
     */
    @RequestMapping("/delete/photo")
    public BaseResult<String> deletePhoto(String id){
        return null;
    }

    /**
     * 更新照片
     * @param photo
     * @return
     */
    @RequestMapping("/update/photo")
    public BaseResult<String> updatePhoto(PhotoParam photo){
        return null;
    }

    /**
     * 解除照片与栏目的关联
     * @param photoIds
     * @param columnId
     * @return
     */
    @RequestMapping("/make/offline/photo")
    public BaseResult<String> makeOffline(List<String> photoIds,String columnId){
        return null;
    }

}
