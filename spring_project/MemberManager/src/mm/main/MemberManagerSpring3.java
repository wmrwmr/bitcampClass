package mm.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import mm.dao.MemberDao;

public class MemberManagerSpring3 {

	static ApplicationContext ctx;

	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx4.xml");
		
		MemberDao dao1 = ctx.getBean("memberDao", MemberDao.class);
		MemberDao dao2 = ctx.getBean("memberDao", MemberDao.class);
		
		System.out.println(" dao1 == dao2 => " + (dao1==dao2));

		
	}
	
	

}
