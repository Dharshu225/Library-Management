package com.dharshiny.application.Repository;

import com.dharshiny.application.Model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel,String>{
    
}
