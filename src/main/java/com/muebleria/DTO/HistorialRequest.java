package com.muebleria.DTO;
import com.muebleria.models.Item;
import com.muebleria.models.Payer;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.sql.Date;
import java.util.List;


public class HistorialRequest {

    @Schema(description = "Identificador de cada registro de historial", example = "2345")
    @NotNull
    private Integer id;

    @Schema(description = "Identificador único del pago", example = "1234567890")
    @NotNull
    private Long paymentId;

    @Schema(description = "ID del usuario que realiza el pago", example = "user123")
    @NotNull
    @Size(min = 5, max = 50)
    private String userId;

    @Schema(description = "Monto total del pago", example = "5000")
    @NotNull
    private Integer amount;

    @Schema(description = "Estado del pago", example = "approved")
    @NotNull
    @Size(min = 5, max = 15)
    private String status;

    @Schema(description = "Método de pago utilizado", example = "credit_card")
    @Size(min = 3, max = 50)
    private String paymentMethod;

    @Schema(description = "Tipo de pago", example = "online")
    @Size(min = 3, max = 50)
    private String paymentType;

    @Schema(description = "Fecha de creación del historial de pago", example = "2025-02-16T10:00:00")
    @Size(max = 50)
    private String dateCreated;

    @Schema(description = "Fecha de aprobación del pago", example = "2025-02-17T10:00:00")
    @Size(max = 50)
    private Date dateApproved;

    @Schema(description = "ID del pagador", example = "1")
    @NotNull
    private Payer payer;  // Solo el ID del payer

    @Schema(description = "Lista de items asociados al pago")
    @NotNull
    private List<Item> items; // Lista de items en la transacción

    public HistorialRequest(Integer id, Long paymentId, String userId, Integer amount, String status, String paymentMethod, String paymentType, String dateCreated, Date dateApproved, Payer payer, List<Item> items) {
        this.id = id;
        this.paymentId = paymentId;
        this.userId = userId;
        this.amount = amount;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.paymentType = paymentType;
        this.dateCreated = dateCreated;
        this.dateApproved = dateApproved;
        this.payer = payer;
        this.items = items;
    }

    // Getters y Setters


    public @NotNull Integer getId() {
        return id;
    }

    public void setId(@NotNull Integer id) {
        this.id = id;
    }

    public @NotNull Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(@NotNull Long paymentId) {
        this.paymentId = paymentId;
    }

    public @NotNull @Size(min = 5, max = 50) String getUserId() {
        return userId;
    }

    public void setUserId(@NotNull @Size(min = 5, max = 50) String userId) {
        this.userId = userId;
    }

    public @NotNull Integer getAmount() {
        return amount;
    }

    public void setAmount(@NotNull Integer amount) {
        this.amount = amount;
    }

    public @NotNull @Size(min = 5, max = 15) String getStatus() {
        return status;
    }

    public void setStatus(@NotNull @Size(min = 5, max = 15) String status) {
        this.status = status;
    }

    public @Size(min = 3, max = 50) String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(@Size(min = 3, max = 50) String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public @Size(min = 3, max = 50) String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(@Size(min = 3, max = 50) String paymentType) {
        this.paymentType = paymentType;
    }

    public @Size(max = 50) String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(@Size(max = 50) String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public @Size(max = 50) Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(@Size(max = 50) Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public @NotNull Payer getPayer() {
        return payer;
    }

    public void setPayer(@NotNull Payer payer) {
        this.payer = payer;
    }

    public @NotNull List<Item> getItems() {
        return items;
    }

    public void setItems(@NotNull List<Item> items) {
        this.items = items;
    }
}
