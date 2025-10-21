class Bank {

    long accounts[];

    public Bank(long[] balance) {
        this.accounts = new long[balance.length+1];
        for(int i = 0; i< balance.length;i++){
            accounts[i+1] = balance[i];
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!(this.accounts.length>=account1) || !(this.accounts.length>=account2)){
            return false;
        }
        if(accounts[account1]- money>=0){
            accounts[account1]-=money;
            accounts[account2]+=money;
                    return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(!(this.accounts.length>=account)){
            return false;
        }
        accounts[account]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if((this.accounts.length>=account)){
            long balancePost = accounts[account]-money;
            if(balancePost>=0){
                accounts[account] = balancePost;
                return true;
            }
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