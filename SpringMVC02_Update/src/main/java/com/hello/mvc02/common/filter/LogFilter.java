package com.hello.mvc02.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

   //클래스 전체에서 사용 가능하게 하기 위해서 클래스로 잡아준다.
   private Logger logger = LoggerFactory.getLogger(LogFilter.class);
   
   
   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {
      // TODO Auto-generated method stub
      HttpServletRequest req = (HttpServletRequest)request;
      
      String remoteAddr = StringUtils.defaultString(request.getRemoteAddr());
      String uri = StringUtils.defaultString(req.getRequestURI());
      String url = StringUtils.defaultString(req.getRequestURL().toString());
      String queryString = StringUtils.defaultString(req.getQueryString());
      String referer = StringUtils.defaultString(req.getHeader("referer"));
      String agent = StringUtils.defaultString(req.getHeader("user-Agent"));
      
      System.out.println("****remoteAddr:" + remoteAddr);
      System.out.println("****uri:" +uri);
      System.out.println("****url:" +url);
      System.out.println("****queryString:"+queryString);
      System.out.println("****referer:"+referer);
      System.out.println("****agent:"+agent);
      
//      StringBuffer sb = new StringBuffer();
//      sb.append(" | ").append(remoteAddr).append(uri).append("(").append(url).append("?").append(queryString).append(")").append(referer).append("|").append(agent);
//      
//      logger.info("LOG FILTER : " + sb);
      
      chain.doFilter(req, response); //조작한 객체를 넘겨주는 메소드
      // *필터의 역할??  request 넘어오면 조작하여 넘긴다
   }

   @Override
   public void destroy() {
      // TODO Auto-generated method stub

   }

}