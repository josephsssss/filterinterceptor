package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public Member save(Member member){
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId){
        return findAll().stream().filter(m -> m.getLoginId().equals(loginId)).findFirst();

        /*
        List<Member> all = findAll();
        for (Member member : all) {
            if (member.getLoginId().equals(loginId)){
                return Optional.of(member);
            }
        }
        return Optional.empty();
        */

    }

    public void clear(){
        store.clear();
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }
}
