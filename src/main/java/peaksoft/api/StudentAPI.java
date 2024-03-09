package peaksoft.api;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.HTTPResponse;
import peaksoft.dto.response.StudentResponse;
import peaksoft.enums.StudyFormat;
import peaksoft.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentAPI {
    private final StudentService studentService;

    @PostMapping("/save")
    public HTTPResponse save(@RequestBody StudentRequest studentRequest){
        return studentService.save(studentRequest);
    }

    @PostMapping("assign/{groupId}/{studentId}")
    public HTTPResponse asSign(@PathVariable Long groupId, @PathVariable Long studentId){
        return studentService.asSign(groupId,studentId);
    }
    @PostMapping ("delete/{studentId}")
    public HTTPResponse delete(@PathVariable Long studentId){
        return studentService.deleteById(studentId);
    }

    @PostMapping("/update/{studentId}")
    public HTTPResponse update(@PathVariable Long studentId,@RequestBody StudentRequest studentRequest){
        return studentService.update(studentId,studentRequest);
    }

    @GetMapping("/all")
    public List<StudentResponse> findAll(){
        return studentService.findAll();
    }

    @GetMapping ("/sortFormat")
    public List<StudentResponse> sortByFormat(@RequestParam StudyFormat studyFormat){
        return studentService.sortByFormat(studyFormat);
    }
    @PostMapping("/block/{studentId}")
    public HTTPResponse blockStudent(@PathVariable Long studentId){
        return studentService.blockStudent(studentId);
    }
}
