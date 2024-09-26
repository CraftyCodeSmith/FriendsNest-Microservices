package com.craftycodesmith.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class AuthserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthserviceApplication.class, args);
//		String url = "jdbc:postgresql://aws-0-ap-south-1.pooler.supabase.com:6543/postgres";
//		String user = "postgres.yvmrlkxspkjsreqvkoff";
//		String password = "FriendsNest@10022000";
//
//		try (Connection conn = DriverManager.getConnection(url, user, password)) {
//			System.out.println("Connected to the database!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
