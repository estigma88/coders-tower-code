package com.coderstower.blog.a_case_integration_tests.application.postgres;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "PAYROLL_INFORMATION")
public class PayrollInformationEntity {
    @Id
    private Integer id;
    private LocalDateTime date;
    private Double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PayrollInformationEntity that))
            return false;
        return Objects.equals(id,
                that.id) && Objects.equals(date,
                that.date) && Objects.equals(
                amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, amount);
    }

    @Override
    public String toString() {
        return "PayrollInformationEntity{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
