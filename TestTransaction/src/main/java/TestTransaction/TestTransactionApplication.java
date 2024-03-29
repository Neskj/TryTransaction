package TestTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestTransactionApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(TestTransactionApplication.class, args);
		System.out.println("Hello my test transaction!");
	}

}
