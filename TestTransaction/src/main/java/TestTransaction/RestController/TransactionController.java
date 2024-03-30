package TestTransaction.RestController;

import TestTransaction.POJO.Account;
import TestTransaction.POJO.TransferRequest;
import TestTransaction.Service.TransferService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    private final TransferService transferService;

    TransactionController(TransferService transferService){
        this.transferService=transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest){

        transferService.transferMoney(transferRequest.getSenderAccount(),
                transferRequest.getReceiverAccount(),transferRequest.getAmount());

    }

    @GetMapping("/accounts")
    public List<Account>  getAllAccounts(){
        return transferService.getAllAccounts();
    }
}
