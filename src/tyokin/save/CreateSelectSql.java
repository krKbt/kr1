package tyokin.save;

public class CreateSelectSql {
	
	public static String selectTyokinList(int aim_id){
		String sql ="select save_money.created_at,memo,save_money.money from save_money inner join aim on save_money.aim_id = aim.id where save_money.aim_id = "+aim_id;
		
		return sql;
	}
	public static String selectAim(int aim_id){
		String sql = "select * from aim where id ="+aim_id;
		
		return sql;
	}	
}
