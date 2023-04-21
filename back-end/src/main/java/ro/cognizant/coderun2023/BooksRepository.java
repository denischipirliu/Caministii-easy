package ro.cognizant.coderun2023;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


@Repository
public interface BooksRepository
        extends CrudRepository<Books,
                            String>{
    Books findBybookName(String bookName);
    List<Books> findALL();
    void deleteBybookName(String bookName);
}
