package com.test.springbootdemo.sever.insert.controller;


import com.alibaba.druid.util.StringUtils;
import com.test.springbootdemo.sever.insert.bean.User;
import com.test.springbootdemo.sever.insert.service.InsertService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RestController
public class InsertController {
    @Autowired
    private InsertService insertService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestBody String data) {
        if (StringUtils.isEmpty(data)){
            return "参数错误";
        }
        System.out.println(data);
        JSONObject object = JSONObject.fromObject(data);
        User user = new User();
        user.setUserId(object.getInt("id"));
        user.setUserName(object.getString("name"));
        insertService.add(user);
        System.out.println(data);
        return data;
    }

    @RequestMapping(value = "/add2", method = RequestMethod.POST)
    @ResponseBody
    public String insert2(@RequestBody String data) {
        if (StringUtils.isEmpty(data)){
            return "参数错误";
        }
        JSONObject object = JSONObject.fromObject(data);
        User user = new User();
        user.setUserId(object.getInt("id"));
        user.setUserName(object.getString("name"));
        insertService.add2(user);
        System.out.println(data);
        return data;
    }

    @RequestMapping(value = "/addSession", method = RequestMethod.POST)
    @ResponseBody
    public String addSession(@RequestBody String data,HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(data)){
            return "参数错误";
        }
        JSONObject object = JSONObject.fromObject(data);
        User user = new User();
        user.setUserId(object.getInt("id"));
        user.setUserName(object.getString("name"));
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        System.out.println(user.toString());
        System.out.println(session.getId());
        Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = (String) e.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+"-------"+value);

        }
        return data;
    }
}
