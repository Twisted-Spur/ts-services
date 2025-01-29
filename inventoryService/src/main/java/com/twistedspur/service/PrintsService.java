package com.twistedspur.service;

import com.azure.storage.blob.BlobClientBuilder;
import com.azure.storage.common.StorageSharedKeyCredential;
import com.twistedspur.dto.PrintDto;
import com.twistedspur.entity.Print;
import com.twistedspur.exception.UploadException;
import com.twistedspur.mapper.PrintMapper;
import com.twistedspur.repository.PrintsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PrintsService {

    @Value("${azure.storage.account-name}")
    private String accountName;

    @Value("${azure.storage.account-key}")
    private String accountKey;

    @Value("${azure.storage.container-name}")
    private String containerName;

    @Autowired
    PrintsRepository printsRepository;

    @Autowired
    PrintMapper printMapper;

    public PrintDto createPrint(MultipartFile multipartFile, PrintDto printDto) {
        String blobUrl = null;
        try {
            blobUrl = uploadToAzureBlob(multipartFile);
        } catch (IOException e) {
            throw new UploadException(String.format("Failed to upload file to cloud storage - %s", e.getMessage()));
        }

        Print print = printMapper.toEntity(printDto);
        print.setUrlToPrint(blobUrl);
        printsRepository.save(print);
        return printMapper.toDto(print);
    }

    private String uploadToAzureBlob(MultipartFile multipartFile) throws IOException {
        StorageSharedKeyCredential credential = new StorageSharedKeyCredential(accountName, accountKey);

        new BlobClientBuilder()
                .endpoint(String.format("https://%s.blob.core.windows.net", accountName))
                .credential(credential)
                .containerName(containerName)
                .blobName(multipartFile.getOriginalFilename())
                .buildClient()
                .upload(multipartFile.getInputStream(), multipartFile.getSize(), true);

        return String.format("https://%s.blob.core.windows.net/%s/%s", accountName, containerName, multipartFile.getOriginalFilename());
    }
}
