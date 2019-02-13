package com.sms.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class FileS3ServiceImpl {

	private AmazonS3 s3client;

	@Value("${amazonProperties.endpointUrl}")
	private String endpointUrl;
	@Value("${amazonProperties.bucketName}")
	private String bucketName;
	@Value("${amazonProperties.accessKey}")
	private String accessKey;
	@Value("${amazonProperties.secretKey}")
	private String secretKey;
	@Value("${amazonProperties.bucketRegion}")
	private String region;

	String fileUrl = "";
	File file;
	String fileName;

	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region))
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
	}

	public String uploadFile(MultipartFile multipartFile) throws IOException {
		fileName = generateFileName(multipartFile);
		byte fileContent[] = multipartFile.getBytes();
		uploadFileBytesToS3bucket(fileName, fileContent);
		fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
		return fileUrl;
	}

	private void uploadFileBytesToS3bucket(String fileName, byte fileContent[]) {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(fileContent);
		ObjectMetadata metadata = new ObjectMetadata();
		Long contentLength = Long.valueOf(inputStream.available());
		metadata.setContentLength(contentLength);
		s3client.putObject(new PutObjectRequest(bucketName, fileName, inputStream, metadata)
				.withCannedAcl(CannedAccessControlList.PublicRead));
	}

	private String generateFileName(MultipartFile multiPart) {
		return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}

	public void deleteFileFromS3Bucket(String fileUrl) {
		fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
		s3client.deleteObject(new DeleteObjectRequest(bucketName, fileName));

	}
}
