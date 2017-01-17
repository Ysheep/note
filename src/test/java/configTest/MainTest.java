package configTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tarena.note.mapper.UserMapper;
import cn.tarena.note.pojo.User;
import cn.tarena.note.service.UserService;

public class MainTest {
	
	ClassPathXmlApplicationContext ctc;
	
	@Before
	public void init() {
		ctc = new ClassPathXmlApplicationContext("spring/applicationContext.xml","spring/applicationContext-mybatis.xml","spring/applicationContext-transaction.xml");
	}
	
	@Test
	public void test_dataSource() throws SQLException {
		BasicDataSource data = ctc.getBean("dataSource",BasicDataSource.class);
		Connection conn = data.getConnection();
		System.out.println(conn);
	}
	
	@Test
	public void test_mapperScanner() {
		Object obj = ctc.getBean("mapperScannerConfigurer");
		System.out.println(obj);
	}
	
	@Test
	public void test_findAll() {
		UserMapper userMapper = ctc.getBean("userMapper",UserMapper.class);
		System.out.println(userMapper);
		String id = "rose";
		User  user = userMapper.findUserByName(id);
		
		System.out.println(user);
		
	}
	
	@Test
	public void test_userSerivce_checkLogin() {
		UserService service = ctc.getBean("userService",UserService.class);
		String name = "Tom";
		String password = "123";
		User user = service.checkLogin(name, password);
		System.out.println(user);
		
		
	}
	
}
