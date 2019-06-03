package com.mj.texi.book.BookService;

import com.alibaba.fastjson.JSON;
import com.mj.texi.book.ServiceImpl.UserServiceImpl;
import com.mj.texi.book.entity.User;
import com.mj.texi.book.mapper.UserMapper;
import com.mj.texi.redis.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImplImp implements UserServiceImpl {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Override
	public User getUserByName(String name) {
		// 具体使用
		User user = new User();
		user.setName("张三");
		user.setSex("f");
		user.setAge(18);
		List<User> list = new ArrayList<>();
		list.add(user);
		redisTemplate.opsForList().leftPush("user:list", JSON.toJSONString(list));
		stringRedisTemplate.opsForValue().set("user:name", "张三");
		stringRedisTemplate.opsForValue().set("user:name", "李四");
		redisTemplate.opsForList().range("user:list",1,10);
		System.out.println(redisTemplate.opsForList().range("user:list",0,100).size());
		System.out.println(redisTemplate.opsForList().range("user:list",0,100).toString());
		Object[] arr = redisTemplate.opsForList().range("user:list",0,10).toArray();
		Object usa = SerializeUtil.unSerialize(SerializeUtil.serialize(arr[0]));

		System.out.println(usa.toString());
		return userMapper.getUserByName(name);
	}

}
