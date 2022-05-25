package com.itcase.dao;

import com.itcase.pojo.User;
import com.itcase.vo.AddUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    //分页查询用户信息+角色信息 多表查询  +模糊查询
    List<User> queryUserByPage(@Param("index") int index,
                               @Param("pageSize") Integer pageSize,
                               @Param("searchParams")String searchParams
                            );

    //查询总条数
    @Select("select count(id) from t_user")
    Integer queryAllUserTotal();

    //增加用户信息 自增主键回填
    @Insert("insert  into t_user values(null,#{username},#{password},#{email},#{remark},now(),now());")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Boolean addUser(AddUser addUser);

    @Insert("insert into  t_user_role values(#{uid},#{rid})")
    void addUserRole(@Param("uid") Integer id, @Param("rid") Integer rid);

    @Delete("delete from t_user_role where user_id = #{uid}")
    void deleteUserRole(@Param("uid") Integer id);

    @Delete("delete from t_user where id = #{uid}")
    void deleteUser(@Param("uid") Integer id);

    @Update("update t_user set username =#{username},password=#{password},email=#{email} where id =#{id}")
    int updateUser(User user);

}
