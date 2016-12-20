package com.ssmo.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssmo.pojo.Car;
import com.ssmo.service.CarService;
import com.ssmo.util.Pager;

@Controller
public class CarController {
	@Resource(name="carService")
	private CarService carService;
	
	@RequestMapping("carController_save")
	public String save(Car car){
		if(car!=null&&car.getId()!=null){
			carService.modify(car);
		}else{
			carService.add(car);
		}
		return "redirect:carController_list";
	}
	
	@RequestMapping(value="carController_findById")
	public ModelAndView findById(@RequestParam(value="id",required=true)Integer id){
		ModelAndView modelAndView = new ModelAndView("caredit");
		Car car=carService.find(id);
		modelAndView.addObject("car",car);
		return modelAndView;
	}
	
	@RequestMapping("carController_remove")
	public String remove(@RequestParam(value="id",required=true)Integer id){
		carService.remove(id);
		return "redirect:carController_list";
	}
	
	@RequestMapping("carController_list")
	public String list(ModelMap modelMap){
		//����ģ�ͣ�ҵ���߼��㣬����ģ�����ݣ�
		List<Car> cars=carService.find();
		//modelMap �൱��Map
		modelMap.put("cars", cars);
		// �߼���ͼ��
		return "carlist";
	}
	
	@RequestMapping("carController_find")
	public ModelAndView find(@RequestParam(value="name") String name,@RequestParam(value="beginDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date beginDate,@RequestParam(value="endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){
		Integer page=1;
		Integer rows=10;
		String sort="id";
		String order="asc";
		if(name!=null && name!=""){
			name = "%" + name + "%";
		}
		Integer pageno = (page-1) * rows;
		Integer pagesize = page * rows;
		
		Pager<Car> cars=carService.findPager(pageno, pagesize, sort, order, name, beginDate, endDate);
		ModelAndView modelAndView =new ModelAndView("carlist");
		modelAndView.addObject("cars", cars.getRows());
		return modelAndView;
	}
}
