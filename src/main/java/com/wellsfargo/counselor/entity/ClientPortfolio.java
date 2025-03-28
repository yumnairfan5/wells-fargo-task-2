package com.wellsfargo.counselor.entity;


import javax.persistance.*;
import java.util.*;

@Entity

public class ClientPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolio_id;

    @Column(nullable = false)
    private String portfolioName;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities = new ArrayList<>();

    public ClientPortfolio(String portfolioName, Client client) {
        this.portfolioName = portfolioName;
        this.client = client;
    }
    public ClientPortfolio(){

    }
    public Long getId() {
        return portfolio_id;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public Client getClient() {
        return client;
    }

    public List<Security> getSecurities() {
        return securities;
    }


    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
