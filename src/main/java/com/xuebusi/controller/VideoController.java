package com.xuebusi.controller;

import com.xuebusi.entity.Course;
import com.xuebusi.repository.CourseRepository;
import com.xuebusi.service.VideoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author caiyuyu
 * @date 2017/11/11
 */
@Controller
@RequestMapping("/course/video")
public class VideoController extends BaseController
{
    @Autowired
    private VideoService videoService;

    @Autowired
    private CourseRepository courseRepository;

    /**
     * 上传本地视频，以 blob 格式保存在数据库
     * @param courseId
     * @param request
     * @return
     */
    @RequestMapping(value = "/{pk}", method = RequestMethod.POST)
    public ResponseEntity upload(@PathVariable("pk") String courseId, HttpServletRequest request)
            throws Exception
    {
        // TODO 绑定视频对象
        File file = new File("");
        if (StringUtils.isBlank(courseId) || null==file)
        {
            throw new Exception("传入参数有误");
        }

        Map<String, Object> returnMap = videoService.uploadVideo(file, courseId);

        return new ResponseEntity(returnMap, HttpStatus.OK);

    }


    /**
     * 加载数据库视频数据
     * @param courseId
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/{pk}/type-one", method = RequestMethod.GET)
    public void loadVideoByTypeOne(@PathVariable("pk") String courseId, HttpServletResponse response)
        throws Exception
    {
        if (StringUtils.isBlank(courseId))
        {
            throw new Exception("传入参数有误");
        }
        videoService.loadVideoByTypeOne(response, courseId);
    }

    /**
     * 加载远程视频数据
     * @param courseId
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/{pk}/type-two", method = RequestMethod.GET)
    public void loadVideoByTypeTwo(@PathVariable("pk") String courseId, HttpServletResponse response)
            throws Exception
    {
        if (StringUtils.isBlank(courseId))
        {
            throw new Exception("传入参数有误");
        }
        videoService.loadVideoByTypeTwo(response, courseId);
    }

    /**
     * 播放视频
     * @param courseId
     * @param request
     * @return
     */
    @RequestMapping(value = "/play/{pk}", method = RequestMethod.GET)
    public ModelAndView play(@PathVariable("pk") String courseId, HttpServletRequest request)
    {
        Map<String, Object> returnMap = new HashMap<>(16);
        Course course = courseRepository.findOne(Integer.parseInt(courseId));
        if (null != course)
        {
            returnMap.put("course_title", course.getCourseTitle());
            returnMap.put("course_id", course.getId());
            return new ModelAndView("/course/play", returnMap);
        }
        return new ModelAndView("/404");
    }

}
