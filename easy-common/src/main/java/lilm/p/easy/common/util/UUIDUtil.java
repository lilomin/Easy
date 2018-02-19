package lilm.p.easy.common.util;

import java.util.UUID;

/**
 * Created by lilm on 17-9-7.
 */
public class UUIDUtil {
	
	public static String createUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
	
}
