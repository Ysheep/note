package cn.tarena.note.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tarena.note.pojo.User;
import cn.tarena.note.service.UserService;
import cn.tarena.note.util.JsonResult;
import cn.tarena.note.util.NameOrPasswordException;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult<User> login(String name,String password) {
		try {
			User user = userService.checkLogin(name, password);
			return new JsonResult<User>(user);
		} catch (NameOrPasswordException e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+","+e.getField());
			return new JsonResult<User>(e.getField(),e.getMessage(),null);
		}
	}
}
