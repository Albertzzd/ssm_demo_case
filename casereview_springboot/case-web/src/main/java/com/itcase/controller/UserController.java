package com.itcase.controller;

import com.itcase.UserService;
import com.itcase.pojo.User;
import com.itcase.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin //允许跨域
public class UserController {

    //注入service对象
    @Autowired
    private UserService userService;
    //查询方法
    @GetMapping("{currentPage}/{pageSize}")
    public Result queryUserByPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        //将前端传输的数据封装为Pagination
        Pagination pagination = new Pagination();
        pagination.setCurrentPage(currentPage);
        pagination.setPageSize(pageSize);
        //调用service方法进行查询
        PageBean  pageBean= userService.queryUserByPage(pagination);

        //返回查询结果
        if(pageBean != null & !pageBean.toString().isEmpty()){
            return new Result(Code.GET_OK,"查询成功",pageBean);
        }
        return new Result(Code.GET_ERR,"查询失败");
    }
    //搜索功能 重载
    @GetMapping("/{currentPage}/{pageSize}/{searchParams}")
    public Result queryUserByPage(@PathVariable Integer currentPage,
                                  @PathVariable Integer pageSize,
                                  @PathVariable String searchParams){
        //将前端传输的数据封装为Pagination
        Pagination pagination = new Pagination();
        pagination.setCurrentPage(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setParam(searchParams);
        //调用service方法进行查询
        PageBean  pageBean= userService.queryUserByPage(pagination);

        //返回查询结果
        if(pageBean != null & !pageBean.toString().isEmpty()){
            return new Result(Code.GET_OK,"查询成功",pageBean);
        }
        return new Result(Code.GET_ERR,"查询失败");
    }

    //增加User
    @PostMapping
    public Result addUser(@RequestBody AddUser addUser){
        Boolean res = userService.addUser(addUser);
        if(res){
            return new Result(Code.SAVE_OK,"增加成功");
        }
        return new Result(Code.SAVE_ERR,"增加失败");
    }
    //删除User
    @DeleteMapping
    public Result deleteUser(@RequestBody User user){
        Boolean res = userService.deleteUser(user);
        if(res){
            return new Result(Code.DELETE_OK,"删除成功");
        }
        return new Result(Code.DELETE_ERR,"删除失败");
    }

    //修改User
    @PutMapping
    public Result updateUser(@RequestBody User user){
        Boolean res = userService.updateUser(user);
        if(res){
            return new Result(Code.UPDATE_OK,"修改成功");
        }
        return new Result(Code.UPDATE_ERR,"修改失败");
    }
}
