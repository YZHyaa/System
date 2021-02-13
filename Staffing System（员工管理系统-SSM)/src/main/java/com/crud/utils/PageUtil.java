package com.crud.utils;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class PageUtil {
	
	public static PageInfo page(int pageNum,List<?> list) {
		PageHelper.startPage(pageNum,3);
		List<?> theList = list;
		return new PageInfo(theList,5);
	}
}
