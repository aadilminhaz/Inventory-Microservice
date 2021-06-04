package com.apnacompany.dukaan;

import com.apnacompany.dukaan.entity.Line;
import com.apnacompany.dukaan.entity.Order;
import com.apnacompany.dukaan.repo.LineRepo;
import com.apnacompany.dukaan.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DukaanApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(DukaanApplication.class, args);
	}

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private LineRepo lineRepo;

	@Override
	public void run(String... args) throws Exception {

		Line line1 = new Line();
		line1.setName("32GB se km RAM nhi h");

		Line line2 = new Line();
		line2.setName("2 lakh ka hai");

		List<Line> lines = new ArrayList<Line>();
		lines.add(line1);
		lines.add(line2);

		Order order1 = new Order();
		order1.setName("LalitKaLaptop");
		order1.getLines().add(line1);
		order1.getLines().add(line2);

		this.orderRepo.save(order1);
	}




}
