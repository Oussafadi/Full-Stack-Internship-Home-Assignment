package ma.dnaengineering.backend.Controllers;


import ma.dnaengineering.backend.Models.Employee;
import ma.dnaengineering.backend.Services.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MainController {
    CsvService<Employee> service ;

    @Autowired
    public MainController(CsvService<Employee> service) {
        this.service = service;
    }

    @PostMapping("/process-csv")
    public ResponseEntity<CustomResponse> processCSV(@RequestParam("csv_file") MultipartFile file) throws IOException {
        List<Employee> employees = service.processUploadedFile(file.getInputStream());
        HashMap<String,Double> summary = service.averageSalaryForEachJobTitle(employees);
        CustomResponse response =CustomResponse.builder()
                .employees(employees)
                .summary(summary)
                .build();

        return ResponseEntity.ok(response);
    }

}
