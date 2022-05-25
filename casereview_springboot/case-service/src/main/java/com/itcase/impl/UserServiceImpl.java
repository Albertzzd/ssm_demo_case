package com.itcase.impl;

import com.itcase.dao.UserDao;
import com.itcase.UserService;
import com.itcase.exception.BusinessException;
import com.itcase.pojo.Role;
import com.itcase.pojo.User;
import com.itcase.vo.AddUser;
import com.itcase.vo.Code;
import com.itcase.vo.PageBean;
import com.itcase.vo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //注入dao层
    @Autowired
    private UserDao userDao;

    //增加用户信息
    @Override
    public Boolean addUser(AddUser addUser) {

        //在用户表信息增加用户信息
        Boolean res = saveUser(addUser);

        //在用户角色表中增加信息
        if(res){

            saveUserRole(addUser);
        }
        return true;
    }

    //修改用户信息 修改之前先删除用户角色中间表的信息
    @Override
    public Boolean updateUser(User user) {
        //修改用户表信息
        int i = userDao.updateUser(user);
        if(i >0 ){
            //修改角色表信息
            deleteUserRole(user);
            //添加用户角色表信息
            saveUserRole(user);
        }
        return true;
    }


    //用户信息删除 -先删除中间表信息再删除用户表信息
    @Override
    public Boolean deleteUser(User user) {
        //删除中间表信息
        Boolean res = deleteUserRole(user);
        if(res) {
            //删除用户表信息
            userDao.deleteUser(Integer.parseInt(user.getId()));
        }
        return true;
    }

    //增加用户信息 自增主键回填
    @Transactional
    public Boolean saveUser(AddUser addUser){
        Boolean res = userDao.addUser(addUser);
        return res;
    }
    //删除用户角色中间表信息
    @Transactional
    public Boolean deleteUserRole(User user){
        userDao.deleteUserRole(Integer.parseInt(user.getId()));
        return true;
    }
    //增加中间表用户角色信息----
    @Transactional
    public void saveUserRole(AddUser addUser){
        List<String> roles = addUser.getRoles();
        for (String role : roles) {
            userDao.addUserRole(addUser.getId(),Integer.parseInt(role));
        }
    }
    //重载添加用户信息
    @Transactional
    public void saveUserRole(User user){
        List<Role> roleList = user.getRoleList();
        for (Role role : roleList) {
            userDao.addUserRole(Integer.parseInt(user.getId()),role.getId());
        }
    }

    //查询用户及角色信息
    @Override
    public PageBean queryUserByPage(Pagination pagination) {
        //传入参数异常判断
        if(pagination.getCurrentPage() <=0 || pagination.getPageSize()<= 0){
            throw new BusinessException(Code.BUSINESS_ERR,"输入参数错误");
        }
        if(pagination.getCurrentPage()==null){
            pagination.setCurrentPage(1);
        }
        if(pagination.getPageSize()==null){
            pagination.setPageSize(5);
        }

        int index = (pagination.getCurrentPage()-1)*pagination.getPageSize();
            //调用dao层进行查询 起始索引 + 每页显示条数  多表查询
        List<User> rows = userDao.queryUserByPage(index, pagination.getPageSize(),pagination.getParam());
        //查询总记录数
        Integer total = userDao.queryAllUserTotal();
        //查询结果异常判断
        PageBean pageBean = new PageBean<User>();
        if(rows != null && !rows.isEmpty() && total !=null) {
            //将查询结果封装进PageBean
            pageBean.setRows(rows);
            pageBean.setTotal(total);
        }
        return pageBean;
    }
}
