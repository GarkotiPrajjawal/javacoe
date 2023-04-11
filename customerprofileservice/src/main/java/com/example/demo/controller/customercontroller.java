package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.services.customerservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import com.example.demo.customer.customer;

@RestController
public class customercontroller {
	@Autowired
	private customerservices customerservices;
	
	@GetMapping("/findAllcustomer")
	public List<customer> getcustomer(){
		return this.customerservices.getcustomer();
	}
	@GetMapping("/findAllcustomer/{id}")
	public Optional<customer> getcustomer(@PathVariable String id){
		return this.customerservices.getcustomer(id);
		
	}
	@PutMapping("/customer")
	public customer updatecustomer(@RequestBody customer customer) {
		return customerservices.updatecustomer(customer);
	}
	@PostMapping("/customer")
	public customer addcustomer(@RequestBody customer customer) {
		return this.customerservices.addcustomer(customer);
	}
	@DeleteMapping("/deletecustomer/{id}")
	public String deletecustomer(@PathVariable String id) {
		return customerservices.deletecustomer(id);
	}
	@PostMapping("/fileSystem")
	public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image")MultipartFile file) throws IOException {
		String uploadImage = customerservices.uploadImageToFileSystem(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	@GetMapping("/fileSystem/{fileName}")
	public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
		byte[] imageData=customerservices.downloadImageFromFileSystem(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
	
}
