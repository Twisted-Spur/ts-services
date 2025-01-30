package com.twistedspur.service;

import com.azure.storage.blob.BlobClientBuilder;
import com.azure.storage.common.StorageSharedKeyCredential;
import com.twistedspur.dto.PrintDto;
import com.twistedspur.entity.Print;
import com.twistedspur.exception.NotFoundException;
import com.twistedspur.exception.UploadException;
import com.twistedspur.mapper.PrintMapper;
import com.twistedspur.repository.PrintsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    public List<PrintDto> getAllPrints() {
        List<Print> prints = printsRepository.findAll();
        return printMapper.toDtos(prints);
    }

    public PrintDto getPrintById(Integer id) {
        Optional<Print> optPrint = printsRepository.findById(id);
        if (optPrint.isEmpty()) {
            throw new NotFoundException("Print with id " + id + " not found");
        }
        return printMapper.toDto(optPrint.get());
    }

    public PrintDto updatePrint(PrintDto printDto, MultipartFile multipartFile) {
        String blobUrl = null;
        try {
            if (multipartFile != null && !multipartFile.isEmpty()) {
                blobUrl = uploadToAzureBlob(multipartFile);
            }
        } catch (IOException e) {
            throw new UploadException(String.format("Failed to upload file to cloud storage - %s", e.getMessage()));
        }

        Optional<Print> optPrint = printsRepository.findById(printDto.id());
        if (optPrint.isEmpty()) {
            throw new NotFoundException("Print with id " + printDto.id() + " not found");
        }

        Print print = printMapper.partialUpdate(printDto, optPrint.get());
        if (blobUrl != null) {
            print.setUrlToPrint(blobUrl);
        }

        printsRepository.save(print);
        return printMapper.toDto(print);
    }

    public void deletePrint(Integer id) {
        printsRepository.deleteById(id);
    }
}
