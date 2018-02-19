package lilm.p.easy.monogo.dao;

import lilm.p.easy.monogo.entity.DocDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by lilm on 18-2-9.
 */
@Component
public class DocDemoDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(DocDemo docDemo) {
		mongoTemplate.save(docDemo);
	}
	
}
