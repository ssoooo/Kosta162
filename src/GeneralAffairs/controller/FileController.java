package GeneralAffairs.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {
	
	@RequestMapping(value="/uploadFile.do", method=RequestMethod.POST)
	public String uploadHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file, Model model){
		
		if(!file.isEmpty()) {
			try {
				byte [] bytes = file.getBytes();
				File dir = new File("c:\\" + File.separator + "tempFiles");
				if(!dir.exists()) {
					dir.mkdirs();
				}
				File saveFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
				out.write(bytes);
				out.close();
				
				model.addAttribute("img", "/images/" + name);
				
				return "group/result";
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
		
	}

/*	
	@RequestMapping(value="/uploadFile.do", method=RequestMethod.POST)
	public @ResponseBody String uploadHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file){
		
		if(!file.isEmpty()) {
			try {
				byte [] bytes = file.getBytes();
				File dir = new File("c:\\" + File.separator + "tempFiles");
				if(!dir.exists()) {
					dir.mkdirs();
				}
				File saveFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
				out.write(bytes);
				out.close();
				
				return "success";
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return "fail";
		
	}*/
}
