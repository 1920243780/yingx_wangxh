package com.baizhi.wxh.service;

import com.baizhi.wxh.annotation.AddCache;
import com.baizhi.wxh.dao.FeedbackMapper;
import com.baizhi.wxh.entity.Feedback;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;

@Service("feedbackService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class FeedbackServiceImpl implements FeedbackService{
    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    @AddCache
    public HashMap<String,Object> queryAll(Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("page",page);
        int records = feedbackMapper.selectCount(new Feedback());
        map.put("records",records);
        if(records%rows==0)
            map.put("total",records/rows);
        else
            map.put("total",records/rows+1);
        RowBounds bounds = new RowBounds((page-1)*rows,rows);
        map.put("rows",feedbackMapper.selectByRowBounds(new Feedback(),bounds));

        return map;
    }
}
