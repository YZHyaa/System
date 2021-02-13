package com.ezhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezhao.entity.Comment;
import com.ezhao.entity.Note;
import com.ezhao.entity.NoteOutline;
import com.ezhao.mapper.NoteMapper;
import com.ezhao.service.note.NoteService;

@Service
public class NoteServiceImpl implements NoteService{
	
	@Autowired 
	NoteMapper noteMapper;

	public void post(Note note) {
		noteMapper.insertNote(note);
	}

	public void commentTo(Comment comment) {
		noteMapper.insertComment(comment);
	}

	public List<NoteOutline> getAllNotes() {
		return noteMapper.findAllNotelList();
	}

	@Override
	public List<NoteOutline> getNoteByLabel(Integer labId) {
		return noteMapper.findNoteListByLab(labId);
	}

	@Override
	public List<NoteOutline> getNoteByTitle(String noteTitle) {
		return noteMapper.findNoteListByTitle(noteTitle);
	}

	@Override
	public Note checkNote(Integer noteId) {
		return noteMapper.findNote(noteId);
	}

	@Override
	public void deleteNote(Integer noteId) {
		noteMapper.deleteNote(noteId);
	}

}
