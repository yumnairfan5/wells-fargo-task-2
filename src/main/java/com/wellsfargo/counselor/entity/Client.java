package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.*;

@Entity

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String contact;

    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private Advisor assignedAdvisor;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClientPortfolio> portfolios = new ArrayList<>();
    public Client(String name, String contact, Advisor assignedAdvisor) {
        this.name = name;
        this.contact = contact;
        this.assignedAdvisor = assignedAdvisor;
    }


    public Client(){

    }
    public Long getId(){
        return id;
    }

    public String getContact() {
        return contact;
    }

    public Advisor getAssignedAdvisor() {
        return assignedAdvisor;
    }


    public String getName() {
        return name;
    }

    public List<ClientPortfolio> getPortfolios() {
        return portfolios;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public void setAssignedAdvisor(Advisor assignedAdvisor) {
        this.assignedAdvisor = assignedAdvisor;
    }

    public void setPortfolios(List<ClientPortfolio> portfolios) {
        this.portfolios = portfolios;
    }
}

