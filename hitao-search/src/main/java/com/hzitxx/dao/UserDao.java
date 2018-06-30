package com.hzitxx.dao;

import com.hzitxx.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDao  extends ElasticsearchRepository<User,Integer> {

}
