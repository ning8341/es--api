package com.lsd.controller;


import com.lsd.bean.DocBean;
import com.lsd.service.IElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 可考虑HttpClient来发起请求es的api服务，或前端直接调用es的api请求服务
 * 需要定制什么api，es提供了丰富的api，直接调用即可
 */

@RestController
@RequestMapping("/elastic")
public class ElasticController {

    @Autowired
    private IElasticService elasticService;

    @GetMapping("/init")
    public void init() {
        elasticService.createIndex();
        List<DocBean> list = new ArrayList<>();
        list.add(new DocBean(1L, "XX0193", "XX8064", "xxxxxx", 1));
        list.add(new DocBean(2L, "XX0210", "XX7475", "xxxxxxxxxx", 1));
        list.add(new DocBean(3L, "XX0257", "XX8097", "xxxxxxxxxxxxxxxxxx", 1));
        elasticService.saveAll(list);

    }

    @GetMapping("/all")
    public Iterator<DocBean> all() {
        return elasticService.findAll();
    }


    @GetMapping("/getByConten")
    public Object getByConten(@RequestParam String content) {
        return elasticService.findByContent(content);
    }


    @GetMapping("/query")
    public Page<DocBean> query(@RequestParam String key) {
        return elasticService.query(key);
    }

}
