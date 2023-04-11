package com.example.demo.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.customer.customer;

public interface customerservices {
	public List<customer> getcustomer();

	public Optional<customer> getcustomer(String id);

	public customer addcustomer(customer customer);

	public customer updatecustomer(customer customer);

	public String deletecustomer(String id);
	
	public byte[] downloadImageFromFileSystem(String fileName) throws IOException;
	
	public String uploadImageToFileSystem(MultipartFile file) throws IOException;

}
