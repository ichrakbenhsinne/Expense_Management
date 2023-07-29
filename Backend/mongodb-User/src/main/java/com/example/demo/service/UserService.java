package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

import com.example.demo.vo.ResponseTemplateVO;
import com.example.demo.entity.Departement;
public interface UserService {

	public User saveuser(User user);
	
	public List<User> getusers();
	
	public User updateUser(Long id, User user);
	
	public void deleteUser(Long id);
	public User finduserbyidentf(String idtfiant);

	public ResponseTemplateVO getuserwithdepartement(String idtfiant );
	public List<Departement> getdeprtments(String idtfiant);

	public void AddDeptToUser(String depname, User user);
	
	
}
