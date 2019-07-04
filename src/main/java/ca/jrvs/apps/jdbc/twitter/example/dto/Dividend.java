package ca.jrvs.apps.jdbc.twitter.example.dto;

public class Dividend {
    private String exDate;
    private String paymentDate;
    private String recordDate;
    private String declaredDate;
    private float amount;

    public String getExDate() {
        return exDate;
    }

    public void setExDate(String exDate) {
        this.exDate = exDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getDeclaredDate() {
        return declaredDate;
    }

    public void setDeclaredDate(String declaredDate) {
        this.declaredDate = declaredDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Dividend{" +
                "exDate='" + exDate + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", recordDate='" + recordDate + '\'' +
                ", declaredDate='" + declaredDate + '\'' +
                ", amount=" + amount +
                '}';
    }
}
