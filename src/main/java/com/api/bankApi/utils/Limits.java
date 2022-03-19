package com.api.bankApi.utils;

/**
 *
 * @author martin
 */
public enum Limits {
    DEPOSIT(40000,150000,4),
    WITHDRAWAL(20000,50000,3);
    
    private final double max_amt;
    private final double max_daily_amt;
    private final int max_count;
    
    private Limits(double max_amt,double max_daily_amt, int max_count) {
        this.max_amt = max_amt;
        this.max_daily_amt = max_daily_amt;
        this.max_count = max_count;
    }
    
    public double valueOfmaxTransactionAmount() {
        return this.max_amt;
    }
    
    public double valueOfmaxDailyAmount() {
        return this.max_daily_amt;
    }
    
    public int valueOfmaxTransactions() {
        return this.max_count;
    }
    
}
