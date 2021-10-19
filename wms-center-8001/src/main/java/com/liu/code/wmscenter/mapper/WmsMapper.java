package com.liu.code.wmscenter.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WmsMapper {
    void stockDec(@Param("name") String productName, @Param("number") int number);
}
