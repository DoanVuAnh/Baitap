package com.example.quanlymu.filter;

import com.example.quanlymu.models.Account;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckLoginFilter extends HttpFilter {
        @Override
        protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException, IOException, ServletException {
            HttpSession session = req.getSession();
            Account account = (Account) session.getAttribute("account");
            if(account == null){
                res.sendRedirect("/login");
            }else {
                chain.doFilter(req,res);
            }
        }
    }