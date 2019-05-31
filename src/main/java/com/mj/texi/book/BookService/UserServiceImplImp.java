package com.mj.texi.book.BookService;

import com.mj.texi.book.ServiceImpl.UserServiceImpl;
import com.mj.texi.book.entity.User;
import com.mj.texi.book.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImplImp implements UserServiceImpl {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User getUserByName(String name) {
		return userMapper.getUserByName(name);
	}

}
