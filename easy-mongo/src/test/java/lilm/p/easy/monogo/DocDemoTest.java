package lilm.p.easy.monogo;

import lilm.p.easy.monogo.dao.DocDemoDao;
import lilm.p.easy.monogo.entity.DocDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lilm on 18-2-9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DocDemoTest {
	
	@Autowired
	private DocDemoDao docDemoDao;
	
	@Test
	public void save() {
		DocDemo docDemo = new DocDemo();
		docDemo.setDocName("test");
		docDemo.setDocPath("/opt/test/db/test.log");
		docDemoDao.save(docDemo);
	}
}
