package tk.baseaccept.pass.chat.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.baseaccept.pass.chat.domain.UserInfo;

import java.util.List;

@Mapper
public interface UserMapper {
	/**
	 * findOne
	 * @param id
	 * @return
	 */
	@Select(value="select *from boot_user where id=#{id}")
	UserInfo findOne(int id);

	/**
	 * findAll
	 * @return
	 */
	@Select(value="select * from boot_user")
	List<UserInfo> findAll();

	@Select(value="select *from boot_user where name=#{name}")
	UserInfo findOneByName(String name );

}
