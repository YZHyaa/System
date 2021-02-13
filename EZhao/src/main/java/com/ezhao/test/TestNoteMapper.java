package com.ezhao.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezhao.entity.Comment;
import com.ezhao.entity.Note;
import com.ezhao.entity.Reply;
import com.ezhao.mapper.NoteMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestNoteMapper {
	
	@Autowired 
	NoteMapper noteMapper;
	
	@Test
	public void m2() {
//		Note note = new Note("�⻹��һ������", "����������", 4, 2, "����");
//		note.setNoteDate(new Date());
//		noteMapper.insertNote(note);
		
//		Comment comment = new Comment("��ô���㻹�ڲ��ԣ�", new Date(),10, "����");
//		noteMapper.insertComment(comment);
		
//		Reply reply = new Reply("�������ǰ�", new Date(), "����", 7);
//		noteMapper.insertReply(reply);
		
//		noteMapper.deleteNote(9);
		
//		System.out.println("1"+noteMapper.findAllNotelList());
		
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(4);
//		list.add(6);
//		System.out.println(noteMapper.findNoteListById(list));
		
//		System.out.println(noteMapper.findNoteListByUid(1));
		
//		System.out.println(noteMapper.findNoteListByLab(3));
		
//		System.out.println(noteMapper.findNoteListByTitle("������"));
//		System.out.println(noteMapper.findNoteListByTitle("��"));
		
		System.out.println(noteMapper.findNote(1));
		
		
		
	}
}
