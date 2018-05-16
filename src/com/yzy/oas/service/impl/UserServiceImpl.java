package com.yzy.oas.service.impl;

import com.yzy.oas.dao.UserDao;
import com.yzy.oas.pojo.Dept;
import com.yzy.oas.pojo.Post;
import com.yzy.oas.pojo.User;
import com.yzy.oas.service.UserService;
import com.yzy.oas.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<UserVo> loadUserList() {
        //查询数据库
        List<User> ulist = userDao.loadUserList();

        //过滤重复元素
        Set<User> set=new HashSet<User>();
        //保存过滤后的vo对象
        List<UserVo> uvoList=new ArrayList<UserVo>();

        UserVo uvo = null;


        /***
         *  1	ddddd	100	研发部	经理
         1	ddddd	100	研发部	主任
         2	zhangsan	111	测试部	经理
         2	zhangsan	111	测试部	客服

         * **/
        for(User u:ulist){

            //添加到set集合，添加的时候，会判断是否已经添加该元素
            if(set.add(u)){
                uvo=new UserVo();
                BeanUtils.copyProperties(u, uvo);
                //给vo对象的pnames属性赋值（pnames:一个用户的所有岗位的名字）
                uvo.setPnames(u.getPname());
                uvoList.add(uvo);
            }else{
                //pnames=pnames+pname
                uvo.setPnames(uvo.getPnames()+","+u.getPname());
            }


        }
        return uvoList;
    }

    @Override
    public void saveUser(UserVo userVo) {
        /**保存用户表中的数据***/
        User user = new User(); //瞬时态
        BeanUtils.copyProperties(userVo, user);
        user.setPassword("888888");
        userDao.addUser(user);
        //变为持久态
        System.out.println("============="+user.getDept().getDname());
        Integer[] pid=userVo.getPid();
        for(Integer id:pid){
            /**建立用户和岗位的关系***/
            Post post = new Post();
            post.setPid(id);
            user.getPsts().add(post);
        }
    }

    @Override
    public void delUser(UserVo userVo) {
        User user=new User();
        user.setUid(userVo.getUid());
        userDao.delUser(user);
    }

    @Override
    public UserVo updateUserUI(Integer uid) {
        User user=userDao.findSingleUser(uid);
        UserVo uvo=new UserVo();
        BeanUtils.copyProperties(user,uvo);

        //uvo对象封装，对应的岗位的id的集合
        Set<Post> psts=user.getPsts();

        Integer[] pids = new Integer[psts.size()];
        Integer index=0;
        for(Post p:psts){
            pids[index]=p.getPid();
            index++;
        }

        uvo.setPid(pids);
        return uvo;
    }

    @Override
    public void updateUser(UserVo userVo) {
        /**保存用户表中的数据***/
        User user = new User(); //瞬时态
        BeanUtils.copyProperties(userVo, user);

        /*//给用户重新分配部门
        Dept dept = new Dept();
        dept.setDid(userVo.getDid());
        user.setDept(dept);*/

        //变为持久态
       // System.out.println("============="+user.getDept().getDname());
        //user.getPsts().clear();
        Integer[] pid=userVo.getPid();
        for(Integer id:pid){
            /**建立用户和岗位的关系***/
            Post post = new Post();
            post.setPid(id);
            user.getPsts().add(post);
        }
        userDao.updateUser(user);
    }

    @Override
    public UserVo loadUserLogin(UserVo userVo) {
        List<User> ulist=userDao.loadUserByUname(userVo.getUsername());
        if(ulist.size()==1){

            //用户输入的密码
            String password=userVo.getPassword();
            //获得数据库查询的密码
            String password2=ulist.get(0).getPassword();
            if(password.equals(password2)){
                UserVo vo = new UserVo();
                BeanUtils.copyProperties(ulist.get(0),vo);
                return vo;
            }
        }
        return null;
    }
}
