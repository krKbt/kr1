package tyokin;

import java.util.Date;


public class SavingMoney{
	private Date date;
	private String memo;
	private int money;
	
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public Date getDate(){
		return date;
	}
	
	public void setMemo(String memo){
		this.memo = memo;
	}
	
	public String getMemo(){
		return memo;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	public int getMoney(){
		return money;
	}
}