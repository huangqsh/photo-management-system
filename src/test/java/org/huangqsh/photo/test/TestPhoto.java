package org.huangqsh.photo.test;

import org.huangqsh.photo.service.IAlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class TestPhoto {
	@Autowired
	private IAlbumService albumService;

	@Test
	public void testFindPhotoListByAlbumId() {
		//albumService.findPhotoListByAlbumId("045bd103-801b-4d1e-923d-32c5546e2140");
	}

}
