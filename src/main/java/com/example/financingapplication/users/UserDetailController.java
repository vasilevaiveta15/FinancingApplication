package com.example.financingapplication.users;

import com.example.financingapplication.users.dtos.UserRegistrationRequestDto;
import com.example.financingapplication.users.dtos.UserRegistrationResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/users")
public class UserDetailController
{
  private final UserDetailService userDetailService;
  private final ModelMapper       modelMapper;

  @Autowired
  public UserDetailController(UserDetailService userDetailService)
  {
    this.userDetailService = userDetailService;
    this.modelMapper = new ModelMapper();
  }

  @PreAuthorize("hasRole('ADMIN')")
  @RequestMapping(value = "/add/user", method = RequestMethod.POST)
  public ResponseEntity<?> registrationUser(@RequestBody UserRegistrationRequestDto userDto)
  {
    this.userDetailService.registrationUser(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(),
        userDto.getPassword(), userDto.getRepeatPassword(), userDto.getRoleName());

    UserDetail userDetail = new UserDetail(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(),
        userDto.getPassword(), UserDetail.RoleName.valueOf(userDto.getRoleName()), "N");

    UserRegistrationResponseDto dto = this.modelMapper.map(userDetail, UserRegistrationResponseDto.class);
    return ResponseEntity.ok(dto);
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping(value = "/lock_account")
  public ResponseEntity<?> lockAccountOfUserByEmail(@RequestParam String email,@RequestParam String isAccountLocked)
  {
    this.userDetailService.lockUserAccount(email, isAccountLocked);
    UserDetail user = this.userDetailService.getUserByEmail(email);
    UserRegistrationResponseDto dto = this.modelMapper.map(user, UserRegistrationResponseDto.class);
    return ResponseEntity.ok(dto);
  }
}
