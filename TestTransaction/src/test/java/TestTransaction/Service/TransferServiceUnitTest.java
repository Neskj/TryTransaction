package TestTransaction.Service;

import TestTransaction.POJO.Account;
import TestTransaction.Repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    public void transferMoneyHappyFlow(){
        Account sender=new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account destination=new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        given(accountRepository.findAccountById(sender.getId()))
                .willReturn(sender);
        given(accountRepository.findAccountById(destination.getId()))
                .willReturn(destination);

        transferService.transferMoney(sender.getId(),destination.getId(),new BigDecimal(100));

        verify(accountRepository)
                .changeAmount(1,new BigDecimal(900));
        verify(accountRepository)
                .changeAmount(2,new BigDecimal(1100));


    }

}
