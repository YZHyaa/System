package com.ezhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezhao.entity.NoteOutline;
import com.ezhao.entity.Resume;
import com.ezhao.mapper.NoteMapper;
import com.ezhao.mapper.UserMapper;
import com.ezhao.service.user.UserService_2;

@Service
public class UserServiceImpl_2 implements UserService_2{
	
	@Autowired
	NoteMapper noteMapper;
	@Autowired 
	UserMapper userMapper;
	
	public List<NoteOutline> getNoteById(Integer authorId) {
		return noteMapper.findNoteListByUid(authorId);
	}

	public List<NoteOutline> getHistory(List<Integer> noteId) {
		return noteMapper.findNoteListById(noteId);
	}

	public Resume checkResume(Integer uId) {
		return userMapper.findUserResume(uId);
	}

	public void editResume(Resume resume) {
		userMapper.updateUserResume(resume);
	}

}
