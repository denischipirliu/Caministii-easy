package ro.cognizant.coderun2023;

import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository
        extends CrudRepository<Books,
                            String>{
    Books findByID(String bookName);
    List<Books> findALL();

}
