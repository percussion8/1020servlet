package green;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿을 Caculator 클래스로 구현
 */
@SuppressWarnings("serial")
@WebServlet("/calc")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("a = " + a + "b = " + b + "의 계산 결과 ");
		writer.println("a + b = " + a + b);
		writer.println("a - b = " + (a - b));
		writer.println("a * b = " + (a * b));
		writer.println("a / b = " + (a - b));
		writer.println("a % b = " + (a %b));


		// TODO Auto-generated method stub
	}

}
