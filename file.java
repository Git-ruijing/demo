package Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.slf4j.spi.LocationAwareLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//未加入中文文件名的处理
import debrisreport.data.This;

@ResponseBody
@Controller
public class file {
	private Logger loger=Logger.getLogger(this.getClass());
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file){
		if (file.isEmpty())
			return "file is empty";
		String fileName = file.getOriginalFilename();
		String suffixname=fileName.substring(fileName.lastIndexOf("."));
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		String strdate=date.format(new Date());
		loger.debug(strdate);
		String filepath= "D:/file"+strdate;
		
		System.getProperties().list(System.out);
		
		if(!new File(filepath).exists()){
			new File(filepath).mkdirs();
		}
			 
		try {
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream=null;
			stream =new BufferedOutputStream(new FileOutputStream(new File(filepath+"/"+file.getOriginalFilename())));
			stream.write(bytes);
			stream.close();
			return "success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "upload";
	}


}
