package ru.pribytkov.servlets;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerServletTest {
    @Test
    public void addItem() throws ServletException, IOException {
        ControllerServlet contServ = new ControllerServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("desc")).thenReturn("zebra");

    }
}