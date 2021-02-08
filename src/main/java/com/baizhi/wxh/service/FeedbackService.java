package com.baizhi.wxh.service;

import java.util.HashMap;

public interface FeedbackService {
    HashMap<String,Object> queryAll(Integer page, Integer rows);
}
