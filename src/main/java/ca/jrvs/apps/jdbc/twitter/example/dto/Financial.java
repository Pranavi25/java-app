package ca.jrvs.apps.jdbc.twitter.example.dto;

import java.math.BigInteger;

public class Financial {
    private String reportDate;
    private BigInteger grossprofit;
    private BigInteger costofRevenue;
    private BigInteger operatingRevenue;
    private BigInteger totalRevenue;
    private BigInteger operatingIncome;
    private BigInteger netIncome;

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public BigInteger getGrossprofit() {
        return grossprofit;
    }

    public void setGrossprofit(BigInteger grossprofit) {
        this.grossprofit = grossprofit;
    }

    public BigInteger getCostofRevenue() {
        return costofRevenue;
    }

    public void setCostofRevenue(BigInteger costofRevenue) {
        this.costofRevenue = costofRevenue;
    }

    public BigInteger getOperatingRevenue() {
        return operatingRevenue;
    }

    public void setOperatingRevenue(BigInteger operatingRevenue) {
        this.operatingRevenue = operatingRevenue;
    }

    public BigInteger getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigInteger totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public BigInteger getOperatingIncome() {
        return operatingIncome;
    }

    public void setOperatingIncome(BigInteger operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    public BigInteger getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(BigInteger netIncome) {
        this.netIncome = netIncome;
    }

    @Override
    public String toString() {
        return "Financial{" +
                "reportDate='" + reportDate + '\'' +
                ", grossprofit=" + grossprofit +
                ", costofRevenue=" + costofRevenue +
                ", operatingRevenue=" + operatingRevenue +
                ", totalRevenue=" + totalRevenue +
                ", operatingIncome=" + operatingIncome +
                ", netIncome=" + netIncome +
                '}';
    }
}
