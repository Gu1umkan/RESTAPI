package peaksoft.api;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.InstructorRequest;
import peaksoft.dto.response.HTTPResponse;
import peaksoft.dto.response.InfoInstructorsResponse;
import peaksoft.dto.response.InstructorResponse;
import peaksoft.service.InstructorService;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
@RequiredArgsConstructor
public class InstructorAPI {
    private final InstructorService instructorService;


    @GetMapping("/all/{companyId}")
    public List<InstructorResponse> findAll(@PathVariable Long companyId){
        return instructorService.findAll(companyId);
    }
    @PostMapping("/save")
    public HTTPResponse save(@RequestBody InstructorRequest instructorRequest){
        return instructorService.save(instructorRequest);
    }
    @PostMapping("assignCompany/{companyId}/{instructorId}")
    public HTTPResponse asSignInstructorToCompany(@PathVariable Long companyId, @PathVariable Long instructorId){
        return instructorService.assign(companyId,instructorId);
    }

    @PutMapping("assignCourse/{courseId}/{instructorId}")
    public HTTPResponse asSignInstructorToCourse(@PathVariable Long courseId,@PathVariable Long instructorId){
        return instructorService.asSignCourse(courseId,instructorId);
    }

    @PostMapping("/update/{instructorId}")
    public HTTPResponse update(@PathVariable Long instructorId,@RequestBody InstructorRequest instructorRequest){
        return instructorService.update(instructorId,instructorRequest);
    }

    @PostMapping("/delete/{instructorId}")
    public HTTPResponse delete(@PathVariable Long instructorId){
        return instructorService.delete(instructorId);
    }

    @GetMapping("/instructorCount/{inId}")
    public Integer count(@PathVariable Long inId){
        return instructorService.countStudent(inId);
    }

    @GetMapping("/info/{instructorId}")
    public InfoInstructorsResponse infos(@PathVariable Long instructorId){
        return instructorService.infoInstructor(instructorId);
    }

}

