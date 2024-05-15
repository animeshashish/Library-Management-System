package com.Library.Management.System.Repository;

import com.Library.Management.System.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
@Transactional
@Modifying
   @Query(value = "update book set quantity = quantity -1 where id =: bookId", nativeQuery = true)
    int updateBookQuantity(Integer bookId);
}
