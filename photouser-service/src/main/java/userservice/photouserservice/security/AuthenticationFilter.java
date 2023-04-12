package userservice.photouserservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sun.jvm.hotspot.runtime.ObjectMonitor;
import userservice.photouserservice.model.LoginRequestModel;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }



    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
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
