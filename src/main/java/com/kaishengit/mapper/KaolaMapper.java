package com.kaishengit.mapper;

import com.kaishengit.entity.Kaola;
import com.kaishengit.entity.KaolaExample;
import java.util.List;
import java.util.Map;

import com.kaishengit.entity.KaolaType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface KaolaMapper {
    long countByExample(KaolaExample example);

    int deleteByExample(KaolaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Kaola record);

    int insertSelective(Kaola record);

    List<Kaola> selectByExample(KaolaExample example);

    Kaola selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Kaola record, @Param("example") KaolaExample example);

    int updateByExample(@Param("record") Kaola record, @Param("example") KaolaExample example);

    int updateByPrimaryKeySelective(Kaola record);

    int updateByPrimaryKey(Kaola record);

    List<Kaola> findByQueryParamWithType(Map<String, Object> queryParam);


    List<String> findAllPlace();
}