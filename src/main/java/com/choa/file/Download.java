package com.choa.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class Download extends AbstractView{
	public Download() {
	
		setContentType("application/download;charset=UTF-8");
	}
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		File f=(File)model.get("downloadFile");
		response.setCharacterEncoding(getContentType());
		response.setContentLength((int)f.length());
		
		String fileName =URLEncoder.encode(f.getName(), "UTF-8");
		fileName= fileName.substring(fileName.lastIndexOf("_")+1);
		String oname = (String)model.get("oname");
		
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		
		FileInputStream fi = null;
		fi = new FileInputStream(f);
		
		FileCopyUtils.copy(fi, out);
		
		fi.close();
		out.close();
		
		
	}

}
