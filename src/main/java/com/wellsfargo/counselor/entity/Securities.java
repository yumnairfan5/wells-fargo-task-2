package com.wellsfargo.counselor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.wellsfargo.counselor.entity.ClientPortfolio;

@Entity

public class Securities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private BigDecimal purchasePrice;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private ClientPortfolio portfolio;

    public Securities(String name, String category, BigDecimal purchasePrice, LocalDate purchaseDate, ClientPortfolio portfolio) {
        this.name = name;
        this.category = category;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.portfolio = portfolio;

    }

    public Securities(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public ClientPortfolio getPortfolio() {
        return portfolio;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public void setPortfolio(ClientPortfolio portfolio) {
        this.portfolio = portfolio;
    }
}
