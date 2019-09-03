package com.example.howtodoinjava.springhystrixstudentservice.controller;

import com.example.howtodoinjava.springhystrixstudentservice.model.Master;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MasterServiceController {
    private static Map<String, List<Master>> schooDB = new HashMap<String, List<Master>>();

    static{
        schooDB = new HashMap<String, List<Master>>();
        List<Master> lst = new ArrayList<Master>();
        Master std = new Master("Irineu", "Class IV");
        lst.add(std);
        std = new Master("Lokesh", "Class V");
        lst.add(std);

        schooDB.put("abcschool", lst);

        lst = new ArrayList<Master>();
        std = new Master("Irineia", "Class III");
        lst.add(std);
        std = new Master("Arabi", "Class VI");
        lst.add(std);

        schooDB.put("xyzschool", lst);
    }

    @RequestMapping(value = "/getMasterDetailsForSchool/{schoolname}", method = RequestMethod.GET)
    public List<Master> getStudents(@PathVariable String schoolname) {
        System.out.println("Getting Student details for " + schoolname);

        List<Master> masterList = schooDB.get(schoolname);
        if (masterList == null) {
            masterList = new ArrayList<Master>();
            Master std = new Master("Not Found", "N/A");
            masterList.add(std);
        }
        return masterList;
    }

}
