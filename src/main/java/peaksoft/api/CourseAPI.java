package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.dto.response.HTTPResponse;
import peaksoft.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseAPI {
    private final CourseService courseService;

    @GetMapping("/all/{companyId}")
    public List<CourseResponse> findAll(@PathVariable Long companyId, @RequestParam String ascOrDesc){
        return   courseService.findAllCourse(companyId,ascOrDesc);
    }

    @PostMapping("/save/{companyId}")
    public HTTPResponse save(@PathVariable Long companyId, @RequestBody CourseRequest courseRequest){
        return courseService.save(companyId,courseRequest);
    }

    @PutMapping("/update/{courseId}")
    public HTTPResponse update( @PathVariable Long courseId, @RequestBody CourseRequest courseRequest){
        return courseService.updatedById(courseId,courseRequest);
    }

    @DeleteMapping("/delete/{courseId}")
    public HTTPResponse delete(@PathVariable Long courseId){
        return courseService.deleteById(courseId);
    }

}
