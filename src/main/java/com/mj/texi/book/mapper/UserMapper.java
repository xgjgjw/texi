package com.mj.texi.book.mapper;

import com.mj.texi.book.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	User getUserByName(String name);
}
