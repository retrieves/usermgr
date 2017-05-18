package com.usermgr.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usermgr.dao.UserDao;
import com.usermgr.entity.User;
import com.usermgr.until.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public int doCreate(User user) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into user(name,sex,birthday) values(?,?,?)";
		try {
			conn = DBUtil.getConnnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));//毫秒数获得参数 转换成日期
			i = pstmt.executeUpdate();//改变了几条数据 i就等于多少
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(conn, pstmt, null);
		}
		return i;
	}

	@Override
	public int doDelete(int id) {
		int i =-1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConnnection();
		try {
			pstmt = conn.prepareStatement("delete from user where id=?");
			pstmt.setInt(1, id);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(conn, pstmt, null);
		}
		return i;
	}

	@Override
	public int doUpdate(User user) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConnnection();
		String sql = "update user set name=?,sex=?,birthday=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			pstmt.setInt(4, user.getId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(conn, pstmt, null);
		}
		return i;
	}

	@Override
	public User getOne(int id) {
		User user = null;
		Connection conn = DBUtil.getConnnection();
		String sql = "select * from user where id =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				user = new User(id,name,sex,birthday);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(conn, pstmt, rs);
		}
		return user;
	}

	@Override
	public List<User> getAll(String keyWord) {
		List<User> users = null;
		Connection conn = DBUtil.getConnnection();
		String sql = "select * from user where "
				+ "id like ? or name like ? or sex like ? or birthday like binary ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyWord+"%");
			pstmt.setString(2, "%"+keyWord+"%");
			pstmt.setString(3, "%"+keyWord+"%");
			pstmt.setString(4, "%"+keyWord+"%");
			rs = pstmt.executeQuery();
			users = new ArrayList<User>();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				User user = new User(id,name,sex,birthday);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(conn, pstmt, rs);
		}
		return users;
	}

}
