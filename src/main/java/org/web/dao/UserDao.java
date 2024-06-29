package org.web.dao;

import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.web.entity.Users;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<Users, Integer> {
    // 實作類 => Spring boot 託管實作起來
    @Transactional
    List<Users> findByEmail(String email);
    List<Users> findByEmailAndPasswd(String email, String passwd);

    @Query("SELECT u FROM Users u WHERE u.email = ?1")
    List<Users> findByEmailJPQL(String email);

    @Query("SELECT u FROM Users u WHERE u.account =?1 AND u.passwd =?2")
    Optional<Users> findByAccountAndPasswd(String account, String passwd);

}
