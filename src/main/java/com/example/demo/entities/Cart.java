package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="carts")
@Getter
@Setter

public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "cart_id")
    private Long id;

    @Column(name= "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name= "package_price")
    private BigDecimal package_price;

    @Column(name= "party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private StatusType.CartStatus status = StatusType.CartStatus.pending;

    @CreationTimestamp
    @Column(name= "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name= "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name= "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    public void add(CartItem item) {
        if (item !=null){
            if (cartItems ==null){
                cartItems = new HashSet<>();
            }
            cartItems.add(item);
            item.setCart(this);
        }
    }

}
