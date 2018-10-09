package eu.onak.hb2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;

import static java.lang.System.exit;

@SpringBootApplication
public class Hb2Application implements CommandLineRunner {

    @Autowired
    ItemService itemService;
    @Autowired
    EntityManagerFactory emf;



	public static void main(String[] args) {
	    SpringApplication app = new SpringApplication(Hb2Application.class);
	    app.run(args);
	}


    public void run(String... args) throws Exception {
        itemService.addItems();
        itemService.readData();

        exit(0);
    }
}
