package com.example.jobboo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jobboo.entity.User;
import com.example.jobboo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

  private final UserRepository userRepository;

  @GetMapping("/")
  @ResponseBody
  public String findUsers() {

    List<User> userList = userRepository.findAll();

    String html = "<html>" +
        "<head><title>잡부</title></head>" +
        "<body style='font-family: Arial, sans-serif;'>" +
        "<h1 style='text-align: center; color: #4CAF50;'>잡부</h1>" +
        "<h2 style='color: #FF5722;'>잡부 명단</h2>" +
        "<table style='width: 100%; border-collapse: collapse;'>" +
        "<thead style='background-color: #f2f2f2;'>" +
        "<tr style='border-bottom: 1px solid #dddddd;'>" +
        "<th style='padding: 8px; text-align: left; background-color: #4CAF50; color: white;'>이름</th>" +
        "<th style='padding: 8px; text-align: left; background-color: #4CAF50; color: white;'>직책</th>" +
        "</tr>" +
        "</thead>" +
        "<tbody>";

    html += userList.stream()
        .map(user -> {
          String username = user.getUsername().isEmpty() ? "없음" : user.getUsername();
          String group = user.getGroupName();
          return "<tr style='border-bottom: 1px solid #dddddd;'>" +
              "<td style='padding: 8px;'>" + username + "</td>" +
              "<td style='padding: 8px;'>" + group + "</td>" +
              "</tr>";
        })
        .collect(Collectors.joining());

    html += "</tbody>" +
        "</table>" +
        "</body>" +
        "</html>";

    return html;
  }

}
