package com.Library.Management.System.Repository;

import com.Library.Management.System.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface BorrowRepository extends JpaRepository<Borrowing, Integer> {


}
