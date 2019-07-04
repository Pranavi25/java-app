package ca.jrvs.apps.jdbc.twitter.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "symbol",
        "companyName",
        "exchange",
        "description",
        "CEO",
        "sector",
        "financials",
        "dividends"
})

public class Company {
    private String symbol;
    private String companyName;
    private String exchange;
    private String description;
    private String CEO;
    private String sector;
    private List<Financial> financials;
    private List<Dividend> dividends;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCEO() {
        return CEO;
    }

    public void setCEO(String CEO) {
        this.CEO = CEO;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public List<Financial> getFinancials() {
        return financials;
    }

    public void setFinancials(List<Financial> financials) {
        this.financials = financials;
    }

    public List<Dividend> getDividends() {
        return dividends;
    }

    public void setDividends(List<Dividend> dividends) {
        this.dividends = dividends;
    }

    @Override
    public String toString() {
        return "Company{" +
                "symbol='" + symbol + '\'' +
                ", companyName='" + companyName + '\'' +
                ", exchange='" + exchange + '\'' +
                ", description='" + description + '\'' +
                ", CEO='" + CEO + '\'' +
                ", sector='" + sector + '\'' +
                ", financials=" + financials +
                ", dividends=" + dividends +
                '}';
    }
}