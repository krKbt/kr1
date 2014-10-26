package tyokin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowTyokinList
 */
@WebServlet("/ShowTyokinList")
public class ShowTyokinList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTyokinList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * tyokinListの表示
		 */
		List allMoney = new ArrayList();
		int sum = 0;
		
		int aimMoney = 0;
		
		String sql ="select * from save_money";
		String aimSql = "select * from aim";
		Connection con = null;
		Statement smt = null;
		
		try{
			con = DBManager.getConnection();
			smt = con.createStatement();
			
			//aim取得
			ResultSet aim = smt.executeQuery(aimSql);
			while(aim.next()){
				String target =aim.getString("target");
				aimMoney =aim.getInt("money");
				
				request.setAttribute("target", target);
				request.setAttribute("money", aimMoney);
			}
			
			ResultSet savingMoney = smt.executeQuery(sql);
			List<SavingMoney> savingMoneyList = new ArrayList<SavingMoney>();
			
			while(savingMoney.next()){
			
			SavingMoney sm = new SavingMoney();
			sm.setDate(savingMoney.getDate("created_at"));
			sm.setMemo(savingMoney.getString("memo"));
			sm.setMoney(savingMoney.getInt("money"));
			
			savingMoneyList.add(sm);
			}
			request.setAttribute("savingMoneyList", savingMoneyList);
			
			//合計金額算出
			for(int i = 0;i<savingMoneyList.size();i++){
				
				int getMoney =savingMoneyList.get(i).getMoney(); 
				allMoney.add(getMoney);
				
				sum= sum+(int)allMoney.get(i);
			}
			
			//残額取得
			//todo aimの金額を取得
			
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.print("<a href='/kr1/change_aim'></a>");
			
			int leftMoney = aimMoney - sum;
			
			if(leftMoney <= 0){
				request.setAttribute("stutas", "お疲れ様でした！");
			}else{
				request.setAttribute("stutas", "目標達成まで残り"+leftMoney+" 円");
			}
			
			request.setAttribute("sum", sum);
			
			
		
			
		}catch(Exception e){
			
		}finally{
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){};
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){};
			}
		}
		
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
