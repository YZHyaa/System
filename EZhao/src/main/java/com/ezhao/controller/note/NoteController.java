package com.ezhao.controller.note;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ezhao.entity.Comment;
import com.ezhao.entity.News;
import com.ezhao.entity.Note;
import com.ezhao.entity.NoteOutline;
import com.ezhao.service.impl.NoteServiceImpl;

/*
 *  “发现”/“发帖”
 * 1.前端知道标签对应ID
 * 2.对每个帖子的id进行保存
 * 3.name与bean相同
 * 4.分页？
 * 5.全部帖子
 */
@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	NoteServiceImpl noteService;
	
	/*
	 * 发帖
	 */
	@RequestMapping("/post")
	public void post(Note note,@RequestParam("picUrl") MultipartFile upfile) throws IllegalStateException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
		String date = sdf.format(new Date());
		String originalFilename = upfile.getOriginalFilename();
		String filename = date+originalFilename.substring(originalFilename.lastIndexOf(','));
		String path = "C:\\Users\\13275\\Documents\\Uploads\\EZhao\\Note";
		File file = new File(path, filename);
		
		upfile.transferTo(file);
		
		String picUrl = path.replace('\\', '/')+'/'+filename;
		note.setPicUrl(picUrl);
		noteService.post(note);
	}
	
	/*
	 * 评论
	 */
	@RequestMapping("/commentTo")
	public void commentTo(Comment comment) {
		noteService.commentTo(comment);
	}
	
	/*
	 * 获取全部帖子列表（分页）
	 */
	@RequestMapping("/getAllNotes")
	@ResponseBody
	public List<NoteOutline> getAllNotes(){
		
		System.out.println("1");
		
		return noteService.getAllNotes();
	}
	

	/*
	 * 根据标签查询帖子列表
	 */
	@RequestMapping("/getNoteByLabel")
	@ResponseBody
	public List<NoteOutline> getNoteByLabel(@RequestParam("labId") Integer labId) {
		
		return noteService.getNoteByLabel(labId);
	}
	
	/*
	 * 根据标题进行搜索帖子列表
	 */
	@RequestMapping("/getNoteByTitle")
	@ResponseBody
	public List<NoteOutline> getNoteByTitle(@RequestParam("noteTitle") String noteTitle){
		
		return noteService.getNoteByTitle(noteTitle);
	}
	
	/*
	 *打开帖子 
	 *将帖子信息放入cookie（注：cookie大小）
	 */
	@RequestMapping("/checkNote/{noteId}")
	@ResponseBody
	public Note checkNote(@PathVariable("noteId") Integer noteId,
			HttpServletRequest request,HttpServletResponse response) {
		
		Cookie[] cs = request.getCookies();
		String noteCookie = "";
		
		String noteid = noteId.toString();
		if(cs == null) {
			noteCookie = noteid;
		}else {
			for(int i=0;i<cs.length;++i) {
				if(cs[i].getName().equals("noteCookie")) {
					if(cs[i].getValue().indexOf(noteid) == -1) {
						noteCookie = noteid+"-"+cs[i].getValue();
						break;
					}else if(cs[i].getValue().indexOf(noteid) == 0) {
						noteCookie = noteid;
						break;
					}else {
						noteCookie = noteid;
						String[] ids = cs[i].getValue().split("\\-");
						for(String str : ids) {
							if(!str.equals(noteid)) {
								noteCookie += "-" + str;
							}
						}
						break;
					}
				}
			}
			
			/*
			if(noteCookie.length()>6) {
				noteCookie = noteCookie.substring(0,6);
			}
			*/
		}
		
		
		Cookie cookie = new Cookie("noteCookie", noteCookie);
		response.addCookie(cookie);
		
		return noteService.checkNote(noteId);
	}
	
	/*
	 * 显示图片
	 */
	public void showPic(@RequestParam("picUrl") String picUrl,
			HttpServletResponse response) throws IOException {
		picUrl.replace('/', '\\');
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(picUrl)));
		response.setContentType("multipart/form-data");
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		int len = 0;
		while((len = bis.read()) != -1) {
			bos.write(len);
			bos.flush();
		}
		bos.close();
		bis.close();
	}
	
	/*
	 * 删除帖子
	 */
	@RequestMapping("/deleteNote")
	@ResponseBody
	public void deleteNote(@PathVariable("noteId") Integer noteId) {
		noteService.deleteNote(noteId);
	}
	
}
