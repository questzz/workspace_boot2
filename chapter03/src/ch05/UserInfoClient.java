package ch05;

public class UserInfoClient {
	
	public static final String MYSQL = "mysql"; 
	public static final String ORACLE = "oracle"; 
	
	public static void main(String[] args) {
		
		// UserInfo 스캐너로 받아서 흐름 만들어 주세요 
		
		
		// 사용한테 userInfo 정보 받는다. 
		UserInfo info = new UserInfo(); 
		info.setUserId("questzz");
		info.setPassword("#1234");
		info.setUserName("홍길동");
		
		// 인터페스 활용 
		
		// 1. A
//		UserInfoMySqlDao mySqlDao = new UserInfoMySqlDao();
//		mySqlDao.insertUserInfo(info);
		
		// 2. B
//		UserInfoOracleDao oracleDao = new UserInfoOracleDao();
//		oracleDao.insertUserInfo(info);
		
		// 1. mysql 문자열이면 --> UserInfoMySqlDao 동작 
		// 2. oracle 문자열이면 --> UserInfoOracleDao 동작 
		// 단. 다형성을 사용해서 처리 해주세요. 
		
		UserInfoDao dao = null;
		
		String str = "oracle";
		
		if(MYSQL.equals(str)) {
			dao = new UserInfoMySqlDao();
		} else if(ORACLE.equals(str)) {
			dao = new UserInfoOracleDao(); 
		} else {
			System.out.println("잘못된 입력 입니다.");
		}
		
		if(dao != null) {
			dao.insertUserInfo(info);
		}
		
	}
}







