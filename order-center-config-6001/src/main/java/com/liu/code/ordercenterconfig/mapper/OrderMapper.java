package com.liu.code.ordercenterconfig.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {
    void createOrder(@Param("name") String productName, @Param("number") int num);
}
