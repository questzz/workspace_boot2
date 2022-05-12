package ch04;

public interface IDepartment {
	
	// 1. 
	// 부서에 대한 전체 정보 
	void selectDepartment();
	
	// departments + 팀장 
	void selectDepartment(String deptNo);
	
}
