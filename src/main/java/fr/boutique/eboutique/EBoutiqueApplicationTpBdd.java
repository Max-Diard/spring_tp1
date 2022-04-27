package fr.boutique.eboutique;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EBoutiqueApplicationTpBdd {

    public static void main(String[] args) {
        SpringApplication.run(EBoutiqueApplicationTpBdd.class, args);
    }

}
