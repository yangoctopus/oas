package com.yzy.oas.service;

import com.yzy.oas.vo.UserVo;

import java.util.List;

public interface UserService {
    List<UserVo> loadUserList();


    void saveUser(UserVo userVo);

    void delUser(UserVo userVo);

    UserVo updateUserUI(Integer uid);

    void updateUser(UserVo userVo);

    UserVo loadUserLogin(UserVo userVo);
}
