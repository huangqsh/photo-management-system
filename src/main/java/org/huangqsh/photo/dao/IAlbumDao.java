package org.huangqsh.photo.dao;

import java.util.List;

import org.huangqsh.photo.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAlbumDao extends JpaRepository<Album,String> {

	/**
	 * 根据 userID查询影集
	 * @param openid
	 * @return
	 */
	@Query(value = "select al from  Album al where al.user.id = :id")
	List<Album> findAllAlbumByid(@Param("id") String id);
	
	Album findAlbumByid(String id);
	
}
