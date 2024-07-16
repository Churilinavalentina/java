package edu.mfti.project;

import edu.mfti.project.repository.BookRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static edu.mfti.project.repository.CreatorDB.createDB;

@SpringBootApplication
@EntityScan("edu.mfti.project")
@ComponentScan("edu.mfti.project")
public class Starter {

    public static void main(String[] args) throws Exception {
        createDB();
        ApplicationContext ctx = SpringApplication.run(Starter.class);
//        BookRepo repo = ctx.getBean(BookRepo.class);
//        System.out.println(repo.findAll());
    }
}