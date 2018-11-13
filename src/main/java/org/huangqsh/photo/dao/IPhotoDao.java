package org.huangqsh.photo.dao;

import org.huangqsh.photo.entity.Album;
import org.huangqsh.photo.entity.Photo;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhotoDao extends JpaRepository<Photo,String> {
	
	PageImpl<Photo> findByAlbum(Album id, Pageable pageable);

}
