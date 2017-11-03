package com.xuebusi.mapper;

import com.xuebusi.entity.WeiboUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author caiyuyu
 * @date 2017/11/2
 */
@Mapper
@Component
public interface WeiboUserMapper extends BaseMapper<WeiboUser>{

    String FIND_WEIBO_INFO_SQL =
    "" +
            "<script>                              " +
            "   SELECT                             " +
            "       a.weibo_id     AS weiboId,     " +
            "       a.access_token AS accessToken  " +
            "   FROM tb_weibo_user AS a            " +
            "   INNER JOIN tb_user AS b            " +
            "       ON a.weibo_id=b.username       " +
            "   WHERE 1=1                          " +
            "       AND a.state=1                  " +
            "       <if test='#{token}!=null'>     " +
            "       AND a.access_token=#{token}    " +
            "       </if>                          " +
            "</script>                             " ;

    /**
     * 通过 token 查询微博授权用户信息
     * @param token
     * @return
     */
    @Select(FIND_WEIBO_INFO_SQL)
    Map<String, Object> findWeiboInfoByToken(@Param("token") String token);
}
