class Bank {

    long[] balance;
    int n;

    public Bank(long[] balance) {
        this.balance = balance;
        n = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        account1 -= 1;
        account2 -= 1;
        if ((account1 < n && account2 < n) && (balance[account1] >= money)) {
            balance[account1] -= money;
            balance[account2] += money;
            return true;
        }
        return false;

    }

    public boolean deposit(int account, long money) {
        account -= 1;
        if (account < n) {
            balance[account] += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        account -= 1;
        if (account < n && (balance[account] >= money)) {
            balance[account] -= money;
            return true;
        }
        return false;
    }
}