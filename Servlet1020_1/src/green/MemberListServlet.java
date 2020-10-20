package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.vo.Member;

@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 지역변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// DB와 연결
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
			/*
			 * Class.forName("org.mariadb.jdbc.Driver"); conn =
			 * DriverManager.getConnection("jdbc:mariadb://localhost/studydb", "root",
			 * "2579"); System.out.println("DB 접속 성공 " + conn);
			 */
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select mno, mname, email, cre_date" + " from members" + " order by mno asc");
			response.setContentType("text/html; charset=utf-8");
			//데이터베이스에서 회원정보를 가져와 Member에 담는다.
			//그리고 맴버객체에 Arrylist를 추가한다
			ArrayList<Member> members = new ArrayList<Member>();

			while (rs.next()) { // DB로부터 가져온 데이터 ResultSet에서 하나씩 가져옴
				members.add(new Member()
						.setNo(rs.getInt("mno"))
						.setName(rs.getString("mname"))
						.setEmail(rs.getString("email"))
						.setCreatedDate(rs.getDate("cre_date"))
						);
			}
				
				request.setAttribute("members", members);
				RequestDispatcher rd = request.getRequestDispatcher(
						"/NewMember/MemberList.jsp"
						);
				rd.include(request, response);
				
		} catch (Exception e) {
			throw new ServletException(); // 예외를 던짐
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
