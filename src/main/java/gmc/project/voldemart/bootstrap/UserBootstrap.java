package gmc.project.voldemart.bootstrap;

import gmc.project.voldemart.domain.User;
import gmc.project.voldemart.repositoies.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;

    public UserBootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();

        User user1 = new User();
        user1.setFirstName("C H");
        user1.setLastName("Parithran Reddy");
        user1.setUserName("reddy");
        user1.setPassword("{noop}reddy");
//        user1.setAddress("FLAT NO 102, SRI SUPRAJA PARADISE  (APT), MAIN ROAD ,KOVUR, NELLORE DISTRICT.");
//        user1.setZipCode(524137);
        user1.setPhoneNumber("+918099992979");
        userList.add(user1);

        User user2 = new User();
        user2.setFirstName("S M");
        user2.setLastName("Logasubramani");
        user2.setUserName("loga");
        user2.setPassword("{noop}loga");
//        user2.setAddress("No 3/788 Karpagambal nagar Madhanadhapuram porur Chennai");
//        user2.setZipCode(600116);
        user2.setPhoneNumber("+919790778113");
        userList.add(user2);
        
        User user3 = new User();
        user3.setUserName("Navin");
        user3.setPassword("{noop}navin@3d");
        userList.add(user3);
        
//        User user4 = new User();
//        user4.setFirstName("M S");
//        user4.setLastName("Kishore");
//        user4.setUserName("kishore");
//        user4.setPassword("{noop}kishore");
//        user4.setEmail("kishoreaadhu@gmail.com");
//        user4.setPhoneNumber("+919442155990");		
//        userList.add(user4);
//
//
//		User user5 = new User();
//		user5.setFirstName("M");
//		user5.setLastName("KrishnaRaghavan");
//		user5.setUserName("KrishnaRaghavan");
//		user5.setPassword("{noop}KrishnaRaghavan");
//		user5.setPhoneNumber("+916383696701");
//        userList.add(user5);

        return userList;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        userRepository.saveAll(getUsers());
    }
}
