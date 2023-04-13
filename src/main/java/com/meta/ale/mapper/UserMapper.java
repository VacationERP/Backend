package com.meta.ale.mapper;

import com.meta.ale.domain.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    public Optional<UserDto> selectByEmpNum(String EmpNum);

    public Optional<UserDto> selectByUserId(Long userId);

    public Long insertUser(UserDto userDto);

    public Long updateRole(UserDto userDto);

    public UserDto selectByEmpId(Long empId) throws Exception;
}
