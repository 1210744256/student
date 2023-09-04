package com.baizhi.controller;

import com.baizhi.entity.Tag;
import com.baizhi.service.TagService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;
import java.util.List;

@Controller
@EnableWebMvc
@RequestMapping("/tag")
@ResponseBody
public class TagController {
    @Autowired
    private TagService tagService;
    @RequestMapping("/queryAll")
    public List<Tag> queryAll() {
       return tagService.list();
    }
    @RequestMapping("/deleteById")
    public void deleteById(int id) {
     tagService.removeById(id);
    }
    @RequestMapping("/insert")
    public void insert(@RequestBody Tag tag) {
        tag.setCreatedate(new Date());
        tagService.save(tag);
    }
    @RequestMapping("/queryTypeAll")
    public List<Tag> queryTypeAll(String type) {
        QueryWrapper<Tag> wrapper=new QueryWrapper<>();
        wrapper.eq("type",type);
        return tagService.list(wrapper);
    }
//    @RequestMapping("/queryEchas")
//    public List<TagResponse> queryEchas(){
//       return tagService.queryEchas();
//    }
}
