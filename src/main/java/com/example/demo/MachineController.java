package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dap.MachineRepo;

@Controller
public class MachineController {
	
	@Autowired
	MachineRepo rep;
	
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("asas");
		return "home.jsp";
	}
	
	@PostMapping(path="/addData")
	@ResponseBody
	public Machine add(@RequestBody Machine m)
	{
		System.out.println("add");
		rep.save(m);
		return m;
	}
	
	@RequestMapping("/showData")
	public ModelAndView show(@RequestParam("mlang") String l)
	{
		ModelAndView mv=new ModelAndView("show.jsp");
		List<Machine> a=rep.findByMlang(l);
		
		
		System.out.println(rep.findByMidGreaterThan(20));
		
		System.out.println(rep.findByMlangSorted(l));
		mv.addObject("m",a);
		return mv;
	}
	
	@GetMapping("/Machines")
	@ResponseBody
	public Iterable<Machine> machines()
	{
		return rep.findAll();
	}
	
	
	
	@GetMapping("/Machine/{mid}")
	@ResponseBody
	public Optional<Machine> machine(@PathVariable("mid") int mid)
	{
		return rep.findById(mid);
	}
	
	@PostMapping("/Machine")
	public Machine add1(Machine m)
	{
		rep.save(m);
		return m;
	}
	
	@DeleteMapping("/Machine/{mid}")
	@ResponseBody
	public String dm(@PathVariable int mid)
	{
		Machine m=rep.findById(mid).orElse(new Machine());
		rep.delete(m);
		return "Deleted";
	}
	
	@PutMapping(path="/Machine",consumes="application/json")
	@ResponseBody
	public Machine saveOrUpdateMachine(@RequestBody Machine m)
	{
		rep.save(m);
		return m;
	}
}
