package tyokin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SettingAim
 */
@WebServlet("/SettingAimMoney")
public class SettingAimMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SettingAimMoney() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf8");
		String aimMoney = request.getParameter("aimMoney");
		String sql = "update aim set money ="+aimMoney; 
		Connection con = null;
		Statement smt = null;
		
		try{
			con = DBManager.getConnection();
			smt = con.createStatement();
			int changeAimMoney = smt.executeUpdate(sql);
			}catch (SQLException e){
				  System.out.println("SQLException");
			}

		response.sendRedirect("ShowTyokinList");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
