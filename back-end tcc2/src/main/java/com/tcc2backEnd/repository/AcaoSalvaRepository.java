package com.tcc2backEnd.repository;

import com.tcc2backEnd.models.AcaoSalva;
import com.tcc2backEnd.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcaoSalvaRepository extends JpaRepository<AcaoSalva, Long> {
    Optional<AcaoSalva> findByTickerAndUser(String ticker, User user);

    boolean existsByUserAndTicker(User user, String ticker);

    List<AcaoSalva> findAllByUser(User user);
}
