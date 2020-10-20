package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.vo.Member;

@SuppressWarnings("serial")
//@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 지역변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
//			Class.forName("org.mariadb.jdbc.Driver");// 드라이버 로딩
//			conn = DriverManager.getConnection(
//					"jdbc:mariadb://localhost/studydb", //JDBC URL
//					"root",	// DBMS 사용자 아이디
//					"2579"); // DBMS 사용자 암호
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select mno,email,mname, cre_date from members " + " where mno =" + request.getParameter("no"));
			if (rs.next()) { // DB로부터 가져온 데이터 ResultSet에서 하나씩 가져옴
				request.setAttribute("member", new Member()
						.setNo(rs.getInt("mno"))
						.setName(rs.getString("mname"))
						.setEmail(rs.getString("email"))
						.setCreatedDate(rs.getDate("cre_date"))
						);
			} else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
			}
			RequestDispatcher rd = request.getRequestDispatcher(
					"/NewMember/MemberUpdateForm.jsp"
					);
			rd.forward(request, response);
			

//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.println("<html><head><title>회원정보</title></head>");
//			out.println("<body><h1>회원정보</h1>");
//			out.println("<form action='update' method='post'>");
//			out.println("번호:<input type='text' name='no' value='" + request.getParameter("no") + "' readonly><br>");
//			out.println("이름:<input type='text' name='name'" + " value = '" + rs.getString("mname") + "'><br>");
//			out.println("이메일:<input type='text' name='email'" + " value = '" + rs.getString("email") + "'><br>");
//			out.println("가입일:" + rs.getDate("cre_date") + "<br>");
//			out.println("<input type='submit' value='저장'>");
//			out.println("<input type='button' value='취소'" + " onclick='location.href=\"list\" '>");
//			out.println("</form>");
//			out.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
			//finally {
//			try {
//				if (rs != null)
//					rs.close();
//			} catch (Exception e) {
//			}
//			try {
//				if (stmt != null)
//					stmt.close();
//			} catch (Exception e) {
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("포스트 잘 들어오나 업데이트 시 ");
		request.setCharacterEncoding("utf-8");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// 드라이버 로딩
			conn = DriverManager.getConnection("jdbc:mysql://localhost/studydb?", // JDBC URL
					"root", // DBMS 사용자 아이디
					"1234"); // DBMS 사용자 암호
			System.out.println("DB 접속 성공 " + conn);
			String sql = "update members set email=?,mname=?,mod_date=now() where mno=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("email"));
			stmt.setString(2, request.getParameter("name"));
			stmt.setInt(3, Integer.parseInt(request.getParameter("no")));
			stmt.execute();
			response.sendRedirect("list");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

}
