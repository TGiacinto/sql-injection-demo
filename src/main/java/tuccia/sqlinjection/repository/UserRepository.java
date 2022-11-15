package tuccia.sqlinjection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tuccia.sqlinjection.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * from user where firstname=:firstname",nativeQuery = true)
    List<User> queryNative(@Param(value = "firstname") String firstname);
}
