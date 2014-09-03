package com.lovo.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lovo.entity.Goods;

@Controller
public class FrontController implements ServletContextAware{
	/**
	 * ʹ�ýӿ�ע�������Ķ���
	 */
	private ServletContext context;
	
	/**
	 * ��ת����¼ҳ��
	 * @return
	 */
	@RequestMapping("test")
	public String goToLogin(){
		return "login";
	}
	
	/**
	 * ��ת����Ʒչʾҳ�棬������Ʒ���ݴ��ݹ�ȥ
	 * @return
	 */
	@RequestMapping("showgoods")
	public ModelAndView showGoods(){
		ModelAndView mav = new ModelAndView();
		List<Goods> list = new ArrayList<>();
		Goods g1 = new Goods("����", 3.5);
		Goods g2 = new Goods("��˿", 3.0);
		Goods g3 = new Goods("�ݸɷ�", 5.0);
		list.add(g1);
		list.add(g2);
		list.add(g3);
		
		mav.addObject("goodsList", list);
		mav.setViewName("showGoods");
		
//		req.setAttribute("goodsList", list);
		
		return mav;
	}
	
	@RequestMapping("goToUp")
	public String goToUpload(){
		return "upload";
	}
	
	@RequestMapping("upload")
	public String upload(@RequestParam("file") CommonsMultipartFile[] files){
		for(CommonsMultipartFile file : files){
			if(!file.isEmpty()){
				String path = context.getRealPath("/WEB-INF/images");
				//ȡ�ļ���ʹ��.getOriginalFilename(),����.getName()
				String filename = file.getOriginalFilename();
				String suffix = "";
				int dot = filename.lastIndexOf(".");
				if(dot >= 0){
					suffix = filename.substring(dot);
				}
				filename = UUID.randomUUID() + suffix;
				try {
					file.transferTo(new File(path + "/" + filename));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "showGoods";
	}
	
	@RequestMapping("jackson")
	public @ResponseBody Goods doJack(){
		Goods goods = new Goods("�׿�ˮ", 100.0);
		
		return goods;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
}
