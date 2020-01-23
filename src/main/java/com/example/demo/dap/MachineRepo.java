package com.example.demo.dap;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Machine;

public interface MachineRepo extends CrudRepository<Machine,Integer>
{
	List<Machine> findByMlang(String mlang);
	List<Machine> findByMidGreaterThan(int mid);
	
	@Query("from Machine where mlang=?1 order by mname")
	List<Machine> findByMlangSorted(String mlang);
	
}
