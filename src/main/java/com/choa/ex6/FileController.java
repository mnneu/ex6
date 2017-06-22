package com.choa.ex6;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.choa.file.FileDTO;
import com.choa.file.MultiFileDTO;
import com.choa.file.SameMultiFileDTO;

@Controller
@RequestMapping(value="/file/**")
public class FileController {
	
	@RequestMapping(value="fileUpload", method=RequestMethod.GET)
	public void fileUpload(){		
	}
	//다중 파일 업로드 -파라미터 이름을 모르거나 갯수가 유동적일때
	
	
	
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
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public void fileUpload(MultipartHttpServletRequest request){	}		
	public void fileUpload(MultipartFile f1){	}
	
	public void fileUpload(FileDTO fileDTO){	}

}
