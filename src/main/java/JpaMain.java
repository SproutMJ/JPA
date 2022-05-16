import domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //JPA 사용을 위해 persistent.xml의 설정 정보를 이용해 엔티티 매니저 팩토리 생성(비용이 크므로 한번만 생성하고 공유). 애플리케이션이 끝날 때 close 호출.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        //엔티티 매니저 생성. 이를 이용해 엔티티를 데이터베이스에 CRUD 가능. 스레드간 공유나 재사용 불가. 사용이 끝나면 close 호출.
        EntityManager em = emf.createEntityManager();
        //트랜잭션 생성
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            logic(em);
            tx.commit();
            System.out.println("OK");
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        em.close();
    }

    public static void logic(EntityManager em){
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("길동");
        member.setAge(10);

        em.persist(member);
        member.setAge(20);

        Member findMember = em.find(Member.class, id);
        System.out.println(findMember);

        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println(members.size());

        em.remove(member);
    }
}
