package com.itcase;

import com.itcase.pojo.User;
import com.itcase.vo.AddUser;
import com.itcase.vo.PageBean;
import com.itcase.vo.Pagination;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {

    PageBean queryUserByPage(Pagination pagination);

    Boolean addUser(AddUser addUser);

    Boolean deleteUser(User user);

    Boolean updateUser(User user);
}
