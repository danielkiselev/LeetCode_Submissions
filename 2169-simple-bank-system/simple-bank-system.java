class Bank {
    long[] accountBalance;


    public Bank(long[] balance) {
        accountBalance = balance;
        
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!checkAccount(account2)){
            return false;
        }
        if(checkAccountFunds(account1, money)){
            accountBalance[account1-1] -= money;
            accountBalance[account2-1] += money;
            return true;
        }
        return false;
        
        
    }
    
    public boolean deposit(int account, long money) {
        if(checkAccount(account)){
            accountBalance[account-1] += money;
            return true;
        }
        return false;
        
    }
    
    public boolean withdraw(int account, long money) {
         if(checkAccountFunds(account, money)){
            accountBalance[account-1] -= money;
            return true;
        }
        return false;
        
    }

    private boolean checkAccount(int acc){
        if(accountBalance.length<acc){
            return false;
        }
        return true;
    }


    private boolean checkAccountFunds(int acc, long money){
        if(!checkAccount(acc)){
            return false;
        }
        long currBalance = accountBalance[acc-1];
        if(currBalance>=money){
            return true;
        }
        return false;
    }


}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */