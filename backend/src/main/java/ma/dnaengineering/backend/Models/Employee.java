package ma.dnaengineering.backend.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id ;
    private String employee_name ;
    private String job_title ;
    private double salary ;

}
