package com.adanac.ssm.tiny.intf.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.adanac.ssm.tiny.intf.common.bean.Student;
import com.adanac.ssm.tiny.intf.dao.StudentDao;

@Repository("studentDao")
public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao {

	private static final String NAMESPACE = "mybatis.mapper.StudentMapper.";

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public int insertStudent(Student student) {
		return getSqlSession().insert(NAMESPACE + "insertStudent", student);
	}

	@Override
	public int deleteByPrimaryKey(Integer studentId) {
		return getSqlSession().delete(NAMESPACE + "deleteStudent", studentId);
	}

	@Override
	public int insert(Student record) {
		return getSqlSession().insert(NAMESPACE + "insert", record);
	}

	@Override
	public int insertSelective(Student record) {
		return getSqlSession().insert(NAMESPACE + "insertSelective", record);
	}

	@Override
	public Student selectByPrimaryKey(Integer studentId) {
		return getSqlSession().selectOne(NAMESPACE + "selectByPrimaryKey", studentId);
	}

	@Override
	public int updateByPrimaryKeySelective(Student record) {
		return getSqlSession().update(NAMESPACE + "updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		return getSqlSession().update(NAMESPACE + "updateByPrimaryKey", record);
	}

	public List<Student> selectAllStudents() {
		return getSqlSession().selectList(NAMESPACE + "selectAllStudents");
	}

	@Override
	public List<Student> dynamicForeach(Map<String, Object> map) {
		return getSqlSession().selectList(NAMESPACE + "dynamicForeach", map);
	}

	@Override
	public int batchInsertStudents(List<Student> studentList) {
		return getSqlSession().insert(NAMESPACE + "batchInsertStudents", studentList);
	}

	@Override
	public int batchInsertStudents(Map<String, Object> studentMap) {
		return getSqlSession().insert(NAMESPACE + "batchInsertStudents2", studentMap);
	}

	@Override
	public int batchDeleteStudents(List<Integer> idList) {
		return getSqlSession().delete(NAMESPACE + "batchDeleteStudents", idList);
	}

	@Override
	public int batchDeleteStudents2(int[] idList) {
		return getSqlSession().delete(NAMESPACE + "batchDeleteStudents2", idList);
	}

}
