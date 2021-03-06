package tk.baseaccept.pass.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.baseaccept.pass.chat.domain.UserInfo;
import tk.baseaccept.pass.chat.mapper.UserInfoMapper;
import tk.baseaccept.pass.chat.service.UserService;

import java.util.List;

/*********************************************************************
 * @Author: Administrator extends BaseAccpet 
 * @Date: 2018/4/12 0012 下午 6:44 
 * @Package: tk.baseaccept.pass.chat.service.impl
 * @ClassInfo
 **********************************************************************/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;
//    private UserMapper userMapper;

    @Override
    public UserInfo getUserInfoByUserId(int Id){
        return userInfoMapper.selectByPrimaryKey(Id);

    }
    @Override
    public List<UserInfo> findUsers(){
        return userInfoMapper.findAll();
    }

    @Override
    public UserInfo getUserByName(String name){
        return userInfoMapper.findOneByName(name);
    }
}
