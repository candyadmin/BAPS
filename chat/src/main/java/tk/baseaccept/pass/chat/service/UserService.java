package tk.baseaccept.pass.chat.service;

import tk.baseaccept.pass.chat.domain.UserInfo;

import java.util.List;

/*********************************************************************
 * @Author: Administrator extends BaseAccpet 
 * @Date: 2018/4/12 0012 下午 6:43 
 * @Package: tk.baseaccept.pass.chat.service
 * @ClassInfo
 **********************************************************************/
public interface UserService  {
    public UserInfo getUserInfoByUserId(int Id);
    public List<UserInfo> findUsers();
    public UserInfo getUserByName(String name);
}
