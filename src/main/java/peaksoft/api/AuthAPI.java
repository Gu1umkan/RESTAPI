package peaksoft.api;

import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.SignInRequest;
import peaksoft.dto.request.SignUpRequest;
import peaksoft.dto.response.HTTPResponse;
import peaksoft.dto.response.SignResponse;
import peaksoft.dto.response.SimpleResponse;

@RestController
@RequestMapping("/api")
public class AuthAPI {
    @PostMapping
    public HTTPResponse signUp(@RequestBody SignUpRequest signUpRequest){
//        return userService.signUp(signUpRequest);
        return null;
    }

    @GetMapping
    public SignResponse signIn(@RequestBody SignInRequest signInRequest){
//        return userService.signIn(signInRequest);
        return null;
    }

}
