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
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
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
		request.setCharacterEncoding("utf8");
		String memo = request.getParameter("memo");
		String money = request.getParameter("money");
		insert(memo,money);
		
		response.sendRedirect("ShowTyokinList");
		
	}

	public void insert(String memo,String money){
		String sql = "insert into save_money(memo,money) values("+"'"+ memo + "'," + money +")";
		Connection con = null;
		Statement smt = null;
		
		try{
			con = DBManager.getConnection();
			smt = con.createStatement();
			int insertMoney = smt.executeUpdate(sql);
			}catch (SQLException e){
				  System.out.println("SQLException");
			}
		
	}
}
