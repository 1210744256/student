package com.baizhi.controller;

import com.baizhi.entity.Group;
import com.baizhi.service.GroupService;
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
@RequestMapping("/group")
@ResponseBody
public class GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping("/queryAll")
    public List<Group> queryAll() {
        return groupService.list();
    }

    @RequestMapping("/delete")
    public void delete(int id) {
        groupService.removeById(id);
    }
    @RequestMapping("/insert")
    public void insert(@RequestBody Group group) {
        group.setCreatedate(new Date(new Date().getTime()));
        groupService.save(group);
    }
    @RequestMapping("/queryById")
    public Group queryById(int id) {
        return groupService.getById(id);
    }
}
