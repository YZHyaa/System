package com.ezhao.controller.news;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ezhao.entity.Comment;
import com.ezhao.entity.News;
import com.ezhao.entity.NewsOutline;
import com.ezhao.service.impl.NewsServiceImpl;
import com.ezhao.service.news.NewsService;

/*
 * “首页（新闻）”
 * 1.图片先设为默认
 * 2.发送多个请求
 * 3.前端知道标签编号
 * 4.前端存储每个新闻编号
 * 5.是否需要数据库细化
 */
@Controller
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	NewsServiceImpl newsService;
	
	/*
	 * 添加新闻
	 */
	@RequestMapping("/addNews")
	public void addNews(News news,@RequestParam("picUrl") MultipartFile file) throws IllegalStateException, IOException {
		String path = "C:\\Users\\13275\\Documents\\Uploads\\EZhao\\News";
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String date = sdf.format(new Date());
		String originalFilename = file.getOriginalFilename();
		String filename = date+originalFilename.substring(originalFilename.lastIndexOf('.'));
		File newfile = new File(path,filename);
		file.transferTo(newfile);
		
		String picurl = path+"\\"+filename;
		picurl.replace('\\', '/');
		news.setPicUrl(picurl);
		newsService.addNews(news);
		
	}
	
	/*
	 * 根据标签查询新闻列表
	 */
	@RequestMapping("/getNewsList")
	@ResponseBody
	public List<NewsOutline> getNewsListByLab(@RequestParam("labId") Integer labId){
		
		return newsService.getNewsListByLab(labId);
	}
	
	/*
	 * 打开新闻
	 */
	@RequestMapping("/checkNews")
	@ResponseBody
	public News checkNews(@RequestParam("newsId") Integer newsId) {

		return newsService.checkNews(newsId);
	}
	
	/*
	 * 显示图片
	 */
	@RequestMapping("/showPic")
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
	 * 添加评论?
	 
	@RequestMapping("/commentTo")
	@ResponseBody
	public void commentTo(Comment comment) {
		
	}
	*/
	
}
