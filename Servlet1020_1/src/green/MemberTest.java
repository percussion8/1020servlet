package green;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import green.vo.Member;

public class MemberTest {
	public static void main(String[] args) {
		
		String[] name = {"박성연", "홍길동", "김말자"};
		String[] email = {"nn@naver.com", "pp@gmail.com", "gg@yahoo.com"};
		String[] password = {"11234", "23456", "77777"};
		int[] no = {1,2,3};
		Member[] members = new Member[3];
		for (int i = 0; i < 3; i++) {
			members[i] = new Member();
			members[i].setName(name[i]).setEmail(email[i]).setPassword(password[i]).setNo(no[i]);
		}
		for(Member i : members) {
			System.out.println("name=" + i.getName() + " email="+i.getEmail()+" pwd="+i.getPassword()+" number="+i.getNo());;
		}
		
		/*
		 * Member[] members = new Member[3]; members[0] = new Member();
		 * members[0].setName("박성연").setEmail("mm@naver.com").setPassword("1234").setNo(
		 * 5); System.out.println();
		 */
			List<Member> alMembers = new ArrayList<Member>();
			alMembers.add((new Member()).setName(name[0]).setEmail(email[0]).setPassword(password[0]).setNo(no[0]));
			System.out.println(alMembers.get(0).getEmail());
			Map<String, Member> mapMembers = new HashMap<String, Member>();
			
		
	}

}
