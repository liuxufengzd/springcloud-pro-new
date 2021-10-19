package com.liu.code.accountcenter.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {
    void balanceChange(@Param("userName") String userName, @Param("money") double money);
}
