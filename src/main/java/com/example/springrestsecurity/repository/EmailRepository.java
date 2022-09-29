package com.example.springrestsecurity.repository;

import com.example.springrestsecurity.domain.Email;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    @Query("select e from Email e where e.isSent = false")
    List<Email> findAllByPendingEmail();

    @Modifying
    @Transactional
    @Query("delete from Email e where e.isSent =false  and  e.id=:id")
    void deletePendingEmail(Long id);


}
