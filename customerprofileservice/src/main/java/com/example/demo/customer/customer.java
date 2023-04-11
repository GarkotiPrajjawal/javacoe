package com.example.demo.customer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Customer")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class customer {
	@Id
	private String id;
	private String name;
	private String mobileno;
	private String filePath;
	private String type;
	
}
