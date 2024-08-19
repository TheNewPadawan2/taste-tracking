package it.uniecampus.lfulgione.tastetracking.ttbe.login.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id = Integer.MAX_VALUE;

    @Size(min = 2, max = 128)
    @NotNull
    @Column(name = "product_name", nullable = false, length = 128)
    private String name;

    @Min(value = 0)
    @Max(value = 5)
    @NotNull
    @Column(name = "product_type", nullable = false)
    private Integer type;

    @Column(name = "creation_date")
    private Timestamp creationDate = new Timestamp(System.currentTimeMillis());

    @Column(name = "delete_date")
    private Timestamp deleteDate = null;
}
