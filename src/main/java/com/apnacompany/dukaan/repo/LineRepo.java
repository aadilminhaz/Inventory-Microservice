package com.apnacompany.dukaan.repo;

import com.apnacompany.dukaan.entity.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepo extends JpaRepository<Line, Long> {
}
