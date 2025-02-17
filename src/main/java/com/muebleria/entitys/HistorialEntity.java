package com.muebleria.entitys;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "historial")
public class HistorialEntity {

    @Id
    private String id;

    @Column(name = "payment_id", nullable = false)
    private Long paymentId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "date_approved")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateApproved;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "date_created")
    private String dateCreated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historial")
    private List<ItemsEntity> items;

    @Embedded
    private PayerEntity payer;

    public HistorialEntity() {}

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getDateApproved() { return dateApproved; }
    public void setDateApproved(Date dateApproved) { this.dateApproved = dateApproved; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getPaymentType() { return paymentType; }
    public void setPaymentType(String paymentType) { this.paymentType = paymentType; }

    public String getDateCreated() { return dateCreated; }
    public void setDateCreated(String dateCreated) { this.dateCreated = dateCreated; }

    public List<ItemsEntity> getItems() { return items; }
    public void setItems(List<ItemsEntity> items) { this.items = items; }

    public PayerEntity getPayer() { return payer; }
    public void setPayer(PayerEntity payer) { this.payer = payer; }
}
