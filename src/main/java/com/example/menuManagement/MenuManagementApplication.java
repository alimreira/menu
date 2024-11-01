package com.example.menuManagement;

import com.example.menuManagement.beanCreation.AutomatedInstance;
import com.example.menuManagement.beanCreation.AutomatedPrototype;
import com.example.menuManagement.beanCreation.Instances;
import com.example.menuManagement.beanCreation.configure.Recipe;
import com.example.menuManagement.implDependency.looseCoupling.Method;
import com.example.menuManagement.implDependency.looseCoupling.Searcher;
import com.example.menuManagement.implDependency.looseCoupling.Sorter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.example.menuManagement")
public class MenuManagementApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {

		ApplicationContext apx = SpringApplication.run(MenuManagementApplication.class, args);

		Instances inn = new Instances(12,"wears");

		AutomatedPrototype auto = apx.getBean(AutomatedPrototype.class);
		AutomatedPrototype auto1 = apx.getBean(AutomatedPrototype.class);
		AutomatedPrototype auto11 = apx.getBean(AutomatedPrototype.class);
		System.out.println(auto);
		System.out.println(auto1);
		System.out.println(auto11);

		Recipe first = apx.getBean("recipe",Recipe.class);
		Recipe first1 = apx.getBean("recipe",Recipe.class);
		System.out.println(first);
		System.out.println(first1);

		Recipe second = apx.getBean("recipe1",Recipe.class);
		Recipe second1 = apx.getBean("recipe1",Recipe.class);
		Recipe second2 = apx.getBean("recipe1",Recipe.class);
		System.out.println(second);
		System.out.println(second1);
		System.out.println(second2);

		Recipe third = apx.getBean("recipe2",Recipe.class);
		Recipe third1 = apx.getBean("recipe2",Recipe.class);
		Recipe third2 = apx.getBean("recipe2",Recipe.class);
		System.out.println(third);
		System.out.println(third1);
		System.out.println(third2);

		Recipe fourth = apx.getBean("bean",Recipe.class);
		Recipe fourth1 = apx.getBean("bean",Recipe.class);
		Recipe fourth2 = apx.getBean("bean",Recipe.class);
		System.out.println(fourth);
		System.out.println(fourth1);
		System.out.println(fourth2);

		Method met = new Method(new Sorter(),new Searcher());
		int host = met.sortSearch(new int[]{12,6,8,14,3,10},10);
		System.out.println(host);


	}

}
