package org.huangqsh.photo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.huangqsh.photo.constant.WebConstants;
import org.huangqsh.photo.dao.PageDto;
import org.huangqsh.photo.entity.Album;
import org.huangqsh.photo.entity.Photo;
import org.huangqsh.photo.entity.User;
import org.huangqsh.photo.entity.dto.AlbumDto;
import org.huangqsh.photo.entity.dto.PhotoDto;
import org.huangqsh.photo.entity.param.ReturnModel;
import org.huangqsh.photo.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class PhotoController {
	@Autowired
	private IAlbumService albumService;
	
	@Value("${filePath.Album}")
	private String filePath;
	
	/**
	 * 根据 openID查询影集
	 */
	@RequestMapping("/album/find")
	public ReturnModel<List<AlbumDto>> findAllAlbum(String id){
		ReturnModel<List<AlbumDto>> reslut = new ReturnModel<>();
		List<AlbumDto> albums = albumService.getAllAlbumByUserId(id);
		reslut.setData(albums);
		return reslut;
	}

	/**
	 * 添加影集(修改)
	 * @param file
	 * @param album
	 * @param request
	 * @return
	 */
	@RequestMapping("/album/add")
	@Transactional
	public ReturnModel<Object> addAlbum(@RequestParam("file") MultipartFile file,Album album,HttpServletRequest request){
		String oldName = file.getOriginalFilename();
		if(album.getId().equals("")||album.getId() == null) {
			//添加
			User user = (User)request.getSession().getAttribute(WebConstants.LOGIN_USER);
			String fileName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
			File albumPoster = new File(filePath+fileName);
			try {
				file.transferTo(albumPoster);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			album.setPoster(fileName);
			album.setAuthorName(user.getNickName());
			album.setUser(user);
			albumService.addAlbumByOpenId(album);
		}else {
			//修改
			Album oldAlbum = albumService.getAlbumById(album.getId());
			if(oldName != oldAlbum.getPoster()) {
				String fileName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
				oldAlbum.setIsPublic(album.getIsPublic());
				oldAlbum.setName(album.getName());
				oldAlbum.setPoster(fileName);
				File albumPoster = new File(filePath+fileName);
				try {
					file.transferTo(albumPoster);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			//可能已经不在一个session，需要手动修改
		}
		return ReturnModel.returnSuccess();
	}
	
	/**
	 * 修改影集(无文件)
	 * @param album
	 * @return
	 */
	@RequestMapping("/album/update")
	public ReturnModel<Object> updateAlbum(Album album){
		albumService.updateAlbum(album);
		return ReturnModel.returnSuccess();
	}
	//删除影集
	
	/**
	 * 上传照片
	 */
	@RequestMapping("/album/photo/add")
	public ReturnModel<Object> addPhoto(@RequestParam("file") MultipartFile[] files,HttpServletRequest request){
		List<Photo> photos = new ArrayList<>();
		for(int i=0; i<files.length; i++) {
			Photo photo = new Photo();
			photo.init();
			photos.add(photo);
			String oldName = files[i].getOriginalFilename();
			String fileName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
			File albumPoster = new File(filePath+fileName);
			try {
				files[i].transferTo(albumPoster);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		User user = (User)request.getSession().getAttribute(WebConstants.LOGIN_USER);
		photos.forEach(s -> {s.setUser(user);});
		albumService.addPhoto(photos);
		return ReturnModel.returnSuccess();
	}
	
	//删除图片
	@RequestMapping("/album/photo/delete")
	public ReturnModel<Object> deletePhoto(List<String> photoIds){
		albumService.deletePhotoById(photoIds);
		return ReturnModel.returnSuccess();
	}
	
	/**
	 * 根据影集查询图片
	 */
	@RequestMapping("/album/photo/findlist")
	public ReturnModel<PageDto<PhotoDto>> findListPhoto(String albumId){
		PageDto<PhotoDto> pages = albumService.findPhotoListByAlbumId(albumId);
		ReturnModel<PageDto<PhotoDto>> retsult = new ReturnModel<>(WebConstants.SUCCESS_CODE,"",pages);
		return retsult;
	}
	//根据作者查询图片
	
	//根据时间查询

}
