package com.weishui.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class WxIsLoginFilter implements Filter {

	public FilterConfig config = null;

	@Override
	public void destroy() {
		this.config = null;
	}

	public static boolean isContains(String container, String[] regx) {
		boolean result = false;

		for (int i = 0; i < regx.length; i++) {
			if (container.indexOf(regx[i]) != -1) {
				return true;
			}
		}
		return result;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);

		String loginStrings = config.getInitParameter("loginStrings");
		String includeStrings = config.getInitParameter("includeStrings");
		String redirectPath = req.getContextPath() + config.getInitParameter("redirectPath");

		String[] loginList = loginStrings.split(";");
		String[] includeList = includeStrings.split(";");

		if (!isContains(req.getRequestURI(), includeList)) {
			chain.doFilter(request, response);
			return;
		}

		if (isContains(req.getRequestURI(), loginList)) {//
			chain.doFilter(request, response);
			return;
		}

		String cookie = req.getHeader("Cookie");
		System.out.println("\ncookie======"+req.getHeader("Cookie"));
		if (cookie == null) {
			wrapper.sendRedirect(redirectPath);
			chain.doFilter(request, response);
			return;
		} else {
			chain.doFilter(request, response);
			return;
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}
}
