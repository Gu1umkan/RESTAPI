package peaksoft.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyInfoResponse;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyAPI {
    private final CompanyService companyService;

    @GetMapping
    public List<CompanyRequest> findAll(){
        return companyService.findAll();
    }

    @PostMapping("/save")
    public CompanyResponse save(@RequestBody CompanyRequest companyRequest) {
        try {
            return companyService.save(companyRequest);
        }catch (Exception e){
            return CompanyResponse.builder()
                    .httpStatus(HttpStatus.OK)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PostMapping("/update/{companyId}")
    public CompanyResponse update(@PathVariable Long companyId,@RequestBody CompanyRequest companyRequest){
        return companyService.updateById(companyId,companyRequest);
    }

    @PostMapping("/delete/{companyId}")
    public CompanyResponse delete(@PathVariable Long companyId){
        return companyService.deleteById(companyId);
    }

    @GetMapping("/info/{companyId}")
    public CompanyInfoResponse infoResponse (@PathVariable Long companyId){
        return companyService.findInfos(companyId);
    }
}

