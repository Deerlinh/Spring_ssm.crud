package com.kaishengit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Kaola;
import com.kaishengit.entity.KaolaType;
import com.kaishengit.entity.KaolaTypeExample;
import com.kaishengit.mapper.KaolaMapper;
import com.kaishengit.mapper.KaolaTypeMapper;
import com.kaishengit.service.KaolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 蔡林红 on 2017/11/4.
 */
@Service
public class KaolaServiceImpl implements KaolaService {

    @Autowired
    private KaolaMapper kaolaMapper;

    @Autowired
    private KaolaTypeMapper kaolaTypeMapper;

    @Override
    public PageInfo<Kaola> findByPageNo(Integer pageNo, Map<String, Object> queryParam) {
        PageHelper.startPage(pageNo,10);

        List<Kaola> list=kaolaMapper.findByQueryParamWithType(queryParam);

         return new PageInfo<>(list);
    }

    @Override
    public Kaola findById(int id) {
        return kaolaMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Kaola kaola) {
    kaola.setCommentNum(0);
        kaolaMapper.insert(kaola);
        }

    @Override
    public List<String> findProducrPlaceList() {
        return kaolaMapper.findAllPlace();
    }

    @Override
    public List<KaolaType> findByTypeAll() {
        return kaolaTypeMapper.selectByExample(new KaolaTypeExample());
    }

    @Override
    public void editKaola(Kaola kaola) {
        kaolaMapper.updateByPrimaryKeySelective(kaola);
    }

    @Override
    public void deleteKaola(Integer id) {
        kaolaMapper.deleteByPrimaryKey(id);

    }


}
