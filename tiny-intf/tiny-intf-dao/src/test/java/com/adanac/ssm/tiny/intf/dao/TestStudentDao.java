package com.adanac.ssm.tiny.intf.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adanac.ssm.tiny.intf.common.bean.Student;
import com.alibaba.fastjson.JSON;

/**
 * 
 * Copyright: 2016 Haiziwang
 * *
 * Author:  fzLiu
 * Date:    2016年12月29日
 * Desc:    studentDao的测试用例
 */
@ContextConfiguration(locations = { "classpath:/config/test-spring-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestStudentDao {
	private static final Logger logger = LoggerFactory.getLogger(TestStudentDao.class);

	@Autowired
	private StudentDao studentDao;

	@Test
	public void test_insert() {
		Student record = new Student();
		record.setStudentId(104);
		record.setStudentName("frank");
		int flag = studentDao.insert(record);
		logger.info(JSON.toJSONString(flag));

	}

	@Test
	public void test_selectByPrimaryKey() {
		Student student = studentDao.selectByPrimaryKey(101);
		logger.info(JSON.toJSONString(student));
	}

	@Test
	public void test_selectAllStudents() throws Exception {
		List<Student> studentList = studentDao.selectAllStudents();
		logger.info(JSON.toJSONString(studentList));
	}

	@Test
	public void test_dynamicForeach() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> ids = new ArrayList<>();
		ids.add(106);
		ids.add(111);
		ids.add(112);
		map.put("ids", ids);
		map.put("studentName", "ada");
		List<Student> studentList = studentDao.dynamicForeach(map);
		logger.info(JSON.toJSONString(studentList));
	}

	@Test
	public void test_batchInsertStudents() {
		List<Student> studentList = new ArrayList<Student>();
		for (int i = 0; i < 3; i++) {
			Student student = new Student();
			student.setStudentName("ada_" + i + "_nac_");
			studentList.add(student);
		}
		int batchInsertStudents = studentDao.batchInsertStudents(studentList);
		logger.info(JSON.toJSONString(batchInsertStudents));
	}

	@Test
	public void test_batchDeleteStudents() {
		List<Integer> idList = new ArrayList<>();
		idList.add(103);
		idList.add(105);
		int batchDeleteStudents = studentDao.batchDeleteStudents(idList);
		logger.info(JSON.toJSONString(batchDeleteStudents));
	}

	@Test
	public void test_batchDeleteStudents2() {
		int[] idList = { 107, 109, 110 };
		int batchDeleteStudents = studentDao.batchDeleteStudents2(idList);
		logger.info(JSON.toJSONString(batchDeleteStudents));
	}
}
