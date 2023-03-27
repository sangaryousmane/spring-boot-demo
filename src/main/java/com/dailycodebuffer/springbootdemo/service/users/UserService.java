package com.dailycodebuffer.springbootdemo.service.users;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    void exportUsersToCsv(HttpServletRequest request);
    void exportUsersToPdf(HttpServletRequest request);
    void exportUsersToExcel(HttpServletRequest request);
}
