package co.yedam.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 초기화 생성자
public class Member {
	
	private String id;
	private String pw;
	private String name;
}
