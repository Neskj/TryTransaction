package TestTransaction.Repository;

import TestTransaction.POJO.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbc;

    AccountRepository(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }

    public Account findAccountById(long id){

        String sql="select * from account where id = ?";

        RowMapper<Account> rowMapper=(r,i)->{
            Account rowAccount = new Account();
            rowAccount.setId(r.getLong("id"));
            rowAccount.setName(r.getString("name"));
            rowAccount.setAmount(r.getBigDecimal("amount"));
            return rowAccount;
        };

        return jdbc.queryForObject(sql,rowMapper,id);
    }

    public  void changeAmount(long id, BigDecimal amount){
        String sql="update account set amount =? where id= ?";
        jdbc.update(sql,amount,id);
    }

    public List<Account> findAllAccounts(){
        String sql="select * from account";
        RowMapper<Account> rowMapper=(r,i)->{
            Account rowAccount = new Account();
            rowAccount.setId(r.getLong("id"));
            rowAccount.setName(r.getString("name"));
            rowAccount.setAmount(r.getBigDecimal("amount"));
            return rowAccount;
        };
        return jdbc.query(sql,rowMapper);
    }
}
