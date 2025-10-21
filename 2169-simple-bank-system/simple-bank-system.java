class Bank {

    HashMap<Integer, Long> accounts;

    public Bank(long[] balance) {
        this.accounts = new HashMap<Integer, Long>();
        for(int i = 0; i< balance.length;i++){
            this.accounts.put(i+1, balance[i]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!this.accounts.containsKey(account1) || !this.accounts.containsKey(account2)){
            return false;
        }
        if(withdraw(account1, money)){
            return deposit(account2, money);
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(!this.accounts.containsKey(account)){
            return false;
        }
        this.accounts.put(account, this.accounts.get(account)+money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(this.accounts.containsKey(account)){
            long balancePost = this.accounts.get(account)-money;
            if(balancePost>=0){
                this.accounts.put(account, balancePost);
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