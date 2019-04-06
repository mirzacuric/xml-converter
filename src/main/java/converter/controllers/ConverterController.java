package converter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import converter.services.ConverterService;

@RestController
@RequestMapping("/api/v1/converter")
public class ConverterController {
    @Autowired
    ConverterService service;

    @PostMapping("/convert")
    public String convert(@RequestParam("file") MultipartFile file) {
        String result = service.convertToXml(file);
        return result;
    }
}