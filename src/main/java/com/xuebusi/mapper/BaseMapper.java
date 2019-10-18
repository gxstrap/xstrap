package com.xuebusi.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author caiyuyu
 * @date 2017/11/2
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
    // Can not be scanned
}
