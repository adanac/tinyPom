package com.adanac.ssm.tiny.intf.dao;

import java.util.List;
import java.util.Map;

import com.adanac.ssm.tiny.intf.common.bean.Student;

public interface StudentDao {

	int deleteByPrimaryKey(Integer studentId);

	int insert(Student record);

	int insertSelective(Student record);

	Student selectByPrimaryKey(Integer studentId);

	List<Student> selectAllStudents();

	List<Student> dynamicForeach(Map<String, Object> map);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);

	int batchInsertStudents(List<Student> studentList);

	int batchInsertStudents(Map<String, Object> studentMap);

	int batchDeleteStudents(List<Integer> idList);

	int batchDeleteStudents2(int[] idList);
}