package com.ssmo.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.ssmo.pojo.Car;
import com.ssmo.service.CarService;
import com.ssmo.util.Pager;

public class CarServiceTest {
	private CarService carService;
	
	@Test
	public void findPager(){
		Integer page=1;
		Integer rows=5;
		String sort="ename";
		String order="asc";
		
		String name=null;
		Date beginDate=null;
		Date endDate=null;
		
		//name="%拉%";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			beginDate=sdf.parse("2016-12-1");
			endDate=sdf.parse("2017-1-1");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Integer pageno=(page-1)*rows;
		Integer pagesize=page*rows;
		
		Pager<Car> pager=carService.findPager(pageno, pagesize, sort, order, name, beginDate, endDate);
		System.out.println("记录总数:"+pager.getTotal());
		for (Car car: pager.getRows()) {
			System.out.println(car.getId()+" "+car.getName()+" "+car.getSaleDate()+" "+car.getPrice());
		}
		
	}
	
	@Test
	public void add() {
		Car car=new Car();
		car.setName("玛莎拉蒂");
		car.setSaleDate(new Date());
		car.setPrice(12000000d);
		carService.add(car);
		if(carService.add(car)>0){
			System.out.println("ok");
		}else{
			System.out.println("error");
		}
	}
	
	@Test
	public void modify(){
		Car car=new Car();
		car.setId(6);
		car.setName("玛莎拉蒂");
		car.setSaleDate(new Date());
		car.setPrice(10000000d);
		if(carService.modify(car)>0){
			System.out.println("ok");
		}else{
			System.out.println("error");
		}
	}
	
	@Test
	public void remove(){
		if(carService.remove(7)>0){
			System.out.println("ok");
		}else{
			System.out.println("error");
		}
	}
	
	@Test
	public void findById(){
		Car car=carService.find(1);
		System.out.println(car.getName()+" "+car.getSaleDate()+" "+car.getPrice());
	}
	
	@Test
	public void find(){
		List<Car> list=carService.find();
		for (Car car : list) {
			System.out.println(car.getName()+" "+car.getSaleDate()+" "+car.getPrice());
		}
	}
	
	@SuppressWarnings("resource")
	@Before
	public void init(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		carService=ctx.getBean("carService",CarService.class);
	}
}
