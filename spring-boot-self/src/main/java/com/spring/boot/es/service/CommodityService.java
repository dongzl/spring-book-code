package com.spring.boot.es.service;

import com.spring.boot.es.entity.Commodity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-11 16:54
 */
public interface CommodityService {

    long count();

    Commodity save(Commodity commodity);

    void delete(Commodity commodity);

    Iterable<Commodity> getAll();

    List<Commodity> getByName(String name);

    Page<Commodity> pageQuery(Integer pageNo, Integer pageSize, String kw);
}
