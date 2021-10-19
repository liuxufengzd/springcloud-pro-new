package com.liu.code.shipcenter.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShipMapper {
    void insertShip(@Param("name") String productName, @Param("number") int number);
}
