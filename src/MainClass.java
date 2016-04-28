package com.pgs.javadev;
/**
 * Created by iwona on 28.04.16.
 */

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@EnableAutoConfiguration

public class MainClass
{
    final static Logger logs = Logger.getLogger(MainClass.class);
    ArrayList<studentsANDgrades> list = new ArrayList<studentsANDgrades>();

    public static void main(String[] args)
    {
        SpringApplication.run(MainClass.class, args);
    }

    //showing all students
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public Object[] showAll()
    {
        logs.info("Show all students");
        return list.toArray();
    }

    //showing one particular student
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public studentsANDgrades showStudent(@PathVariable int id)
    {
        logs.info("Show student of ID: "+id);
        return list.get(id);
    }

    //adding new student
    @RequestMapping(value = "/add/{name}&{surname}", method = RequestMethod.PUT)
    @ResponseBody
    public void addStudent(@PathVariable String name, @PathVariable String surname)
    {
        logs.info("Add new student: "+name+" "+surname);
        list.add(new studentsANDgrades(list.size(), name, surname));
    }

    //deleting existing student
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteStudent(@PathVariable int id)
    {
        logs.info("Delete student: "+list.get(id).toString());
        list.remove(id);
    }

    //setting grade to particular student
    @RequestMapping(value = "/set/{id}&{grade}", method = RequestMethod.PUT)
    @ResponseBody
    public boolean setGradeToStudent(@PathVariable int id, @PathVariable int grade)
    {
        logs.info("Add new grade: "+grade+" to student of ID: "+id);
        return list.get(id).setGrade(grade);
    }

}
