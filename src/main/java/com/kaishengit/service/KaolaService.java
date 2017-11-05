package com.kaishengit.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Kaola;
import com.kaishengit.entity.KaolaType;

import java.util.List;
import java.util.Map;

/**
 * Created by 蔡林红 on 2017/11/4.
 */

public interface KaolaService {

    PageInfo<Kaola> findByPageNo (Integer pageNo, Map<String,Object> queryParam);

    Kaola findById(int id);

    void save(Kaola kaola);

    List<String> findProducrPlaceList();

    List<KaolaType> findByTypeAll();

    void editKaola(Kaola kaola);

    void deleteKaola(Integer id);
}
