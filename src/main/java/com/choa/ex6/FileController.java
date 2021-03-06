package com.choa.ex6;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.choa.file.FileDTO;
import com.choa.file.FileService;
import com.choa.file.MultiFileDTO;
import com.choa.file.SameMultiFileDTO;
import com.choa.util.SeDTO;

@Controller
@RequestMapping(value="/file/**")
public class FileController {
	
	
	
	//SmartEditor
	@RequestMapping(value="seUpload", method=RequestMethod.POST)
	public String seUpload(SeDTO seDTO, HttpSession session)throws Exception{	
	/*	Enumeration<Object> e=request.getParameterNames();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());			
		}
		Iterator<String> it=request.getFileNames();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
/*		//callBack
		String callback = seDTO.getCallback();
		//callback_func
		String callback_func = seDTO.getCallback_func();
		//oname
		String original_name = seDTO.getFiledata().getOriginalFilename();
		//defaultPath
		String defaultPath = session.getServletContext().getRealPath("resources/upload");
		
		File f = new File(defaultPath);
		//폴더가 존재하지 않으면 만들어라...
		if(!f.exists()){
			f.mkdirs();
		}
		//폴더에 저장할 파일명 
		String realName = UUID.randomUUID().toString()+"_"+original_name;
		//폴더에 저장
		seDTO.getFiledata().transferTo(new File(f, realName));*/
		
		//
		/*String file_result = "&bNewLine=true&sFileName="+original_name+"&sFileURL=/ex6/resources/upload/"+realName;
		
		return "redirect:"+callback+"?callback_func="+callback_func+file_result;*/
		FileService fs = new FileService();
		return fs.seUpload(seDTO, session);		
	}
	//파일 다운
	@RequestMapping(value="fileDown", method=RequestMethod.GET)
	public ModelAndView fileDown(String fileName, HttpSession session,String oname){
		String realPath = session.getServletContext().getRealPath("resources/upload");
		File f = new File(realPath, fileName);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("download");
		mv.addObject("downloadFile", f);
		mv.addObject("oname", oname);
		return mv;
	}
	
	
	
	//파일 삭제 
	@RequestMapping(value="fileDelete",method=RequestMethod.GET)
	public void fileDelete(String fileName, HttpSession session)throws Exception{
		FileService f = new FileService();
		f.fileDelete(fileName, session);
		
	}
	
	@RequestMapping(value="fileUpload", method=RequestMethod.GET)
	public void fileUpload(){		
	}
	//다중 파일 업로드 -파라미터 이름을 모르거나 갯수가 유동적일때
	@RequestMapping(value="upload", method=RequestMethod.POST)	
	public void upload(MultipartHttpServletRequest request){
		
		Iterator<String> it=request.getFileNames();
		ArrayList<MultipartFile> muti = new ArrayList<MultipartFile>();
		while (it.hasNext()){
			MultipartFile m = request.getFile(it.next());
			muti.add(m);			
		}
		for(MultipartFile m : muti){
			System.out.println(m.getOriginalFilename());
		}
		
	}
	
	
	//다중 파일 업로드 -파라미터 이름이 같을때 
	@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST)	
	public void sameMultiFileUpload(MultipartHttpServletRequest request){
		List<MultipartFile> ar =request.getFiles("f1");
		for(MultipartFile f: ar){
			System.out.println(f.getOriginalFilename());
		}
		
	}
	
	
	public void sameMultiFileUpload(SameMultiFileDTO sameMultiFileDTO){
		for(int i=0; i<sameMultiFileDTO.getF1().length; i++){
		 System.out.println(sameMultiFileDTO.getF1()[i].getOriginalFilename());
		}
		
	}
	
	public void sameMultiFileUpload(MultipartFile [] f1){
		for(int i=0; i<f1.length; i++){
		 System.out.println(f1[i].getOriginalFilename());
		}
		
	}
	
	//다중 파일 업로드 -파라미터 이름이 다를때
	@RequestMapping(value="multiFileUpload", method=RequestMethod.POST)
	public void multiFileUpload(MultipartHttpServletRequest request){		
		MultipartFile f1 = request.getFile("f1");
		MultipartFile f2 = request.getFile("f2");
		System.out.println(f1.getOriginalFilename());
		System.out.println(f2.getOriginalFilename());
	}	
	public void multiFileUpload(MultiFileDTO multiFileDTO){		
		System.out.println(multiFileDTO.getF1().getOriginalFilename());
		System.out.println(multiFileDTO.getF2().getOriginalFilename());		
	}
	public void multiFileUpload(MultipartFile f1, MultipartFile f2){		
		System.out.println(f1.getOriginalFilename());
		System.out.println(f2.getOriginalFilename());		
	}
	
	//단일 파일 업로드
	
	public void fileUpload(MultipartHttpServletRequest request){	}	
	
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public ModelAndView fileUpload(MultipartFile f1, HttpSession session)throws Exception{	
		
		FileService fileService = new FileService();
		String fileName=fileService.fileSave(f1, session);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("file/fileView");
		mv.addObject("fileName", fileName);
		mv.addObject("oname", f1.getOriginalFilename());
		return mv;
		
	}
	
	public void fileUpload(FileDTO fileDTO){	}

}
