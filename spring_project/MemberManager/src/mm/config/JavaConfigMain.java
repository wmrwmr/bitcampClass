package mm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import mm.dao.MemberDao;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

@Configuration
//@Import(JavaConfigSub.class)
@ImportResource("classpath:appCtxSub.xml")
public class JavaConfigMain {
	
	// MemberDao
	@Bean(name = "dao")
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	// MemberRegService : dao  주입
	@Bean
	public MemberRegService regService() {
		return new MemberRegService(memberDao());
	}
	

	
}





