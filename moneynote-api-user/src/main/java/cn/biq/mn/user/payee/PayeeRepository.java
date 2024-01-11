package cn.biq.mn.user.payee;

import cn.biq.mn.user.book.Book;
import org.springframework.stereotype.Repository;
import cn.biq.mn.base.base.BaseRepository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PayeeRepository extends BaseRepository<Payee>  {

    boolean existsByBookAndName(Book book, String name);

    long countByBook(Book book);

    Optional<Payee> findOneByBookAndId(Book book, Integer id);

    void deleteByBook(Book book);

    List<Payee> findByBookAndEnableAndCanExpense(Book book, Boolean enable, Boolean canExpense);

    List<Payee> findByBookAndEnableAndCanIncome(Book book, Boolean enable, Boolean canIncome);

}
