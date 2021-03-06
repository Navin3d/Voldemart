package gmc.project.voldemart.bootstrap;

import gmc.project.voldemart.domain.Authorities;
import gmc.project.voldemart.domain.Roles;
import gmc.project.voldemart.repositoies.AuthoritiesRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AuthoritiesBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthoritiesRepository authoritiesRepository;

    public AuthoritiesBootstrap(AuthoritiesRepository authoritiesRepository) {
		super();
		this.authoritiesRepository = authoritiesRepository;
	}

	public ArrayList<Authorities> getAuthorities() {
        ArrayList<Authorities> authoritiesList = new ArrayList<>();
        Authorities authorities = new Authorities();
        authorities.setUserName("Navin");
        authorities.setAuthority(Roles.ADMIN);
        authoritiesList.add(authorities);
        
        Authorities authorities1 = new Authorities();
        authorities1.setUserName("reddy");
        authorities1.setAuthority(Roles.USER);
        authoritiesList.add(authorities1);

        Authorities authorities2 = new Authorities();
        authorities2.setUserName("loga");
        authorities2.setAuthority(Roles.USER);
        authoritiesList.add(authorities2);
        
        Authorities authorities3 = new Authorities();
        authorities3.setUserName("kishore");
        authorities3.setAuthority(Roles.USER);
        authoritiesList.add(authorities3);

		Authorities authorities4 = new Authorities();
		authorities4.setUserName("KrishnaRaghavan");
		authorities4.setAuthority(Roles.USER);
        authoritiesList.add(authorities4);
        
        return authoritiesList;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        authoritiesRepository.saveAll(getAuthorities());
    }
}
