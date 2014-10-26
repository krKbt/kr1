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
 * Servlet implementation class UpdateAim
 */
@WebServlet("/UpdateAim")
public class UpdateAim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAim() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String newTarget = request.getParameter("newTarget");
		String newMoney = request.getParameter("newAimMoney");
		String sql_updateAim = "update aim set target='"+newTarget+"'"+",money='"+newMoney+"'";
		System.out.println(sql_updateAim);
		String sql_deleteAll = "delete from save_money";
		Connection con = null;
		Statement smt = null;
		try{
			con = DBManager.getConnection();
			smt = con.createStatement();
			int updateAim = smt.executeUpdate(sql_updateAim);
			int deleteAllSaveMoney = smt.executeUpdate(sql_deleteAll);
			}catch (SQLException e){
				  System.out.println("SQLException");
			}
		response.sendRedirect("ShowTyokinList");
		
	}

}
