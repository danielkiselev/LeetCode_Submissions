class Bank {

    private long accounts[];

    public Bank(long[] balance) {
        this.accounts = balance.clone();
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!(this.accounts.length>=account1) || !(this.accounts.length>=account2) ||accounts[account1-1]- money<0){
            return false;
        }
        this.accounts[account1-1]-=money;
        this.accounts[account2-1]+=money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!(this.accounts.length>=account)){
            return false;
        }
        this.accounts[account-1]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!(this.accounts.length>=account)||accounts[account-1]-money<0){
            return false;
        }
        this.accounts[account-1] -= money;
        return true;

    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */