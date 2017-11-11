package com.xuebusi.service;

import com.xuebusi.entity.Course;
import com.xuebusi.repository.CourseRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

/**
 * @author caiyuyu
 * @date 2017/11/11
 */
@Service
public class VideoService {

    private final static Logger LOGGER = LoggerFactory.getLogger(VideoService.class);

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CourseRepository courseRepository;


    /**
     * 上传视频
     * @param file
     * @param courseId
     * @return
     */
    public Map<String, Object> uploadVideo(File file, String courseId) throws Exception
    {
        Map<String, Object> returnMap = new HashMap<>(16);

        // 实例化本地视频对象 TODO
        // 将本地视频拷贝到远程云服务器, 返回url TODO

        // 可能需要设置数据库 max_allowed_packet 参数
        BufferedInputStream fstream = new BufferedInputStream(new FileInputStream(file));

        Session session = entityManager.unwrap(Session.class);
        Blob blob = Hibernate.getLobCreator(session).createBlob(fstream, file.length());

        Course course = courseRepository.findOne(Integer.parseInt(courseId));
        if (null != course)
        {
            course.setCourseData(blob);
        }

        return returnMap;
    }

    /**
     * 加载数据库视频数据
     * @param response
     * @param courseId
     * @throws Exception
     */
    public void loadVideoByTypeOne(HttpServletResponse response, String courseId) throws Exception
    {
        Course course = courseRepository.findOne(Integer.parseInt(courseId));
        if (null != course)
        {
            OutputStream o = response.getOutputStream();
            InputStream i = course.getCourseData().getBinaryStream();
            byte[] buffer;
            buffer = new byte[i.available()];
            LOGGER.info("buffer 大小{}", buffer.length);
            i.read(buffer);
            o.write(buffer);
            o.flush();
            o.close();
        }
    }

    /**
     * 加载
     */
    public void loadVideoByTypeTwo(HttpServletResponse response, String courseId) throws Exception
    {
        Course course = courseRepository.findOne(Integer.parseInt(courseId));
        if (null != course)
        {
            // 获取课程视频远程 url 地址
            String url = course.getCourseLink();
            File file = new File(url);
            OutputStream o = response.getOutputStream();
            InputStream i = new FileInputStream(file);
            byte[] buffer;
            buffer = new byte[i.available()];
            LOGGER.info("buffer 大小{}", buffer.length);
            i.read(buffer);
            o.write(buffer);
            o.flush();
            o.close();
        }
    }
}
