package org.huangqsh.photo.service;

import java.util.List;

import org.huangqsh.photo.dao.PageDto;
import org.huangqsh.photo.entity.Album;
import org.huangqsh.photo.entity.Photo;
import org.huangqsh.photo.entity.dto.AlbumDto;
import org.huangqsh.photo.entity.dto.PhotoDto;

public interface IAlbumService {

	/**
	 * 根据 用户ID查询影集
	 * @param openid
	 * @return
	 */
	List<AlbumDto> getAllAlbumByUserId(String openid);

	/**
	 * 添加影集
	 * @param album
	 */
	void addAlbumByOpenId(Album album);

	/**
	 * 修改影集
	 * @param album
	 */
	void updateAlbum(Album album);

	/**
	 * 通过影集id查询影集
	 * @param id
	 */
	Album getAlbumById(String id);

	/**
	 * 通过影集id查询照片
	 * @param page
	 * @return
	 */
	PageDto<PhotoDto> findPhotoListByAlbumId(String albumId);

	/**
	 * 添加照片
	 * @param photo
	 * @return
	 */
	void addPhoto(List<Photo> photo);

	/**
	 * 根据照片id删除照片
	 * @param photoId
	 */
    void deletePhotoById(List<String> photoIds);
}
