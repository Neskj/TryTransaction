package TestTransaction.POJO;

import java.math.BigDecimal;

public class TransferRequest {
    private long senderAccount;
    private long receiverAccount;
    private BigDecimal amount;

    public long getSenderAccount() {
        return senderAccount;
    }

    public long getReceiverAccount() {
        return receiverAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setSenderAccount(long senderAccount) {
        this.senderAccount = senderAccount;
    }

    public void setReceiverAccount(long receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

