package com.baizhi.wxh.controller;

import com.baizhi.wxh.service.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Resource
    private FeedbackService feedbackService;

    @RequestMapping("queryAll")
    @ResponseBody
    public HashMap<String,Object> queryAll(Integer page,Integer rows){
        return feedbackService.queryAll(page,rows);
    }
}
