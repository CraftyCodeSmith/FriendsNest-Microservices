package com.craftycodesmith.authservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedConfig {

//    @Bean
//    public CommandLineRunner seedData(JdbcTemplate jdbcTemplate) {
//        return args -> {
//            try {
//                ClassPathResource resource = new ClassPathResource("db/seed/data.sql");
//                ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//                databasePopulator.addScript(resource);
//                databasePopulator.setContinueOnError(true);
//                databasePopulator.populate(jdbcTemplate.getDataSource().getConnection());
//                System.out.println("Database seeded successfully!");
//            } catch (ScriptException e) {
//                System.err.println("Error during database seeding: " + e.getMessage());
//            }
//        };
//    }

}
