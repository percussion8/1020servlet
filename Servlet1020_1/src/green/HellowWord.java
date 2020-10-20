package green;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


// @WebServlet("hello")
public class HellowWord implements Servlet {

	ServletConfig config;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// 어플리케이션 종료될때 자동으로 호출
		System.out.println("destroy 호출");

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig 메서드 호출");
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo 메서드 호출");
		return "version = 10.; author = 이재오; 저작권  : 그린2020";
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		// 어플리케이션 실행시 자동으로 호출됨
		System.out.println("init 메서드 호출");

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// init 메서드 다음으로 호출되는 메서드
		// service 메서드 에서 doget, dopost 로 전달됨
		System.out.println("service 메서드 호출");

	}

}
