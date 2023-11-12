package com.example.financingapplication.exceptions;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("restAuthenticationEntryPoint")
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint
{
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response,
                       AuthenticationException authenticationException) throws IOException
  {
    response.setContentType("application/json");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.getOutputStream().println("{ \"error\": \"" + authenticationException.getMessage() + "\" }");
  }
}
