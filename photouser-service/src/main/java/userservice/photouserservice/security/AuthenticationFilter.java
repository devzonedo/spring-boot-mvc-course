package userservice.photouserservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.userdetails.User;
import sun.jvm.hotspot.runtime.ObjectMonitor;
import userservice.photouserservice.model.LoginRequestModel;
import userservice.photouserservice.service.UserService;
import userservice.photouserservice.shared.UserDto;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private UserService userService;
    private Environment environment;


    public AuthenticationFilter(UserService userService,Environment environment,AuthenticationManager authenticationManager) {
        super(authenticationManager);
        this.userService = userService;
        this.environment = environment;
    }



    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String username = ((User) auth.getPrincipal()).getUsername();
        UserDto userDetails = userService.getUserDetailsByEmail(username);
    }

    public Authentication attempAuthentication(HttpServletRequest req,
                                               HttpServletResponse res) throws AuthenticationException {
        try{
            LoginRequestModel cerds = new ObjectMapper()
                    .readValue(req.getInputStream(),LoginRequestModel.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            cerds.getEmail(),
                            cerds.getPassword(),
                            new ArrayList<>()));

        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }

}
