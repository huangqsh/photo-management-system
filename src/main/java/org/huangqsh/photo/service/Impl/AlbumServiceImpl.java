package org.huangqsh.photo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.huangqsh.photo.dao.IAlbumDao;
import org.huangqsh.photo.dao.IPhotoDao;
import org.huangqsh.photo.dao.PageDto;
import org.huangqsh.photo.entity.Album;
import org.huangqsh.photo.entity.Photo;
import org.huangqsh.photo.entity.dto.AlbumDto;
import org.huangqsh.photo.entity.dto.PhotoDto;
import org.huangqsh.photo.service.IAlbumService;
import org.huangqsh.photo.utils.DateUtil;
import org.huangqsh.photo.utils.PageParam;
import org.huangqsh.photo.utils.PageThreadlocal;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlbumServiceImpl implements IAlbumService {
	
	@Autowired
	private IAlbumDao albumDao;
	
	@Autowired
	private IPhotoDao photoDao;
	
	@Value("${fileURL.Album}")
	private String fileURL;

	@Override
	public List<AlbumDto> getAllAlbumByUserId(String id) {
		List<Album> albums = albumDao.findAllAlbumByid(id);
		List<AlbumDto> albumDtos = new ArrayList<>();
		albums.forEach(a -> {
			AlbumDto dto = new AlbumDto();
			BeanUtils.copyProperties(a, dto);
			dto.setPoster(fileURL+a.getPoster());
			dto.setCreateDate(DateUtil.formatDateString(a.getCreateDate(), "yyyy-MM-dd"));
			albumDtos.add(dto);
		});
		return albumDtos;
	}

	@Override
	public void addAlbumByOpenId(Album album) {
		album.init();
		albumDao.save(album);
	}

	@Override
	@Transactional
	public void updateAlbum(Album album) {
		Album oldAlbum = albumDao.findAlbumByid(album.getId());
		oldAlbum.setName(album.getName());
		oldAlbum.setIsPublic(album.getIsPublic());
	}

	@Override
	public Album getAlbumById(String id) {
		Album album = albumDao.findAlbumByid(id);
		return album;
	}

	@Override
	public PageDto<PhotoDto> findPhotoListByAlbumId(String albumId) {
		PageParam page = PageThreadlocal.getThread();
		Sort sort = Sort.by(Direction.DESC,"createDate");
		Pageable pageable = PageRequest.of(page.getPageNum(), page.getPageSize(),sort);
		Album album = new Album();
		album.setId(albumId);
		PageImpl<Photo> pageImpl = photoDao.findByAlbum(album,pageable);
		List<PhotoDto> dtos = new ArrayList<>();
		pageImpl.getContent().forEach(p -> {
			PhotoDto dto = new PhotoDto();
			BeanUtils.copyProperties(p, dto);
			dto.setUrl(fileURL+p.getUrl());
			dtos.add(dto);
		});
		PageDto<PhotoDto> pageDto = new PageDto<>();
		pageDto.setData(dtos);
		pageDto.setPageable(pageImpl.getPageable());
		pageDto.setPageTotal(pageImpl.getTotalPages());
		return pageDto;
	}

	@Override
	public void addPhoto(List<Photo> photos) {
		photoDao.saveAll(photos);
	}

	@Override
	public void deletePhotoById(List<String> photoIds) {
		List<Photo> photos = new ArrayList<>();
		photoIds.forEach(id -> {
			Photo p = new Photo();
			p.setId(id);
			photos.add(p);
		});
		photoDao.deleteAll(photos);
	}

}
