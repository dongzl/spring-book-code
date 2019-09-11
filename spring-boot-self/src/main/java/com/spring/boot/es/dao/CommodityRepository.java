package com.spring.boot.es.dao;

import com.spring.boot.es.entity.Commodity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dongzonglei
 * @description
 * @date 2019-09-11 16:52
 */
@Repository
public interface CommodityRepository extends ElasticsearchRepository<Commodity, String> {


}
