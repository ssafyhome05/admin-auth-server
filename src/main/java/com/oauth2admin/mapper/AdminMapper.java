package com.oauth2admin.mapper;

import com.oauth2admin.entity.AdminEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

	@Insert("INSERT INTO admin (admin_pw, admin_role) VALUE (#{adminPw}, #{adminRole})")
	@Options(useGeneratedKeys = true)
	void insertAdmin(AdminEntity admin);

	@Select("SELECT * FROM admin WHERE admin_seq = #{adminSeq}")
	AdminEntity findAdminBySeq(String adminSeq);
}
