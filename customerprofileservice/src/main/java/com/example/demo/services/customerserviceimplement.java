package com.example.demo.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import com.example.demo.repository.customerrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.customer.customer;

@Service
public class customerserviceimplement implements customerservices {
	private final String FOLDER_PATH="C:/Users/Book2/OneDrive/Documents/images/";
	@Autowired
	private customerrepository customerrepository;

	@Override
	public List<customer> getcustomer() {
		// TODO Auto-generated method stub
		return customerrepository.findAll();
	}

	@Override
	public Optional<customer> getcustomer(String id) {
		// TODO Auto-generated method stub
		return customerrepository.findById(id);
	}

	@Override
	public customer addcustomer(customer customer) {
		// TODO Auto-generated method stub
		return customerrepository.save(customer);
	}

	@Override
	public customer updatecustomer(customer customer) {
		// TODO Auto-generated method stub
		return customerrepository.save(customer);
	}

	@Override
	public String deletecustomer(String id) {
		// TODO Auto-generated method stub
		customerrepository.deleteById(id);
		return "customer deleted with id : " + id;
	}
	public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        customer fileData=customerrepository.save(customer.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<customer> fileData = customerrepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }

}
