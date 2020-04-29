package com.sme.spring.mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Represents domain of customer.
 */
@Entity
@Table(name = "Customer")
public class Customer extends BaseEntity
{
    private static final int TEN = 10;

    @NotEmpty(message = "First Name must not be empty")
    private String firstname;

    @NotEmpty(message = "Last Name must not be empty")
    private String lastname;

    @NotEmpty(message = "Phone number must contain 10 digits")
    @Digits(fraction = 0, integer = TEN)
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setAddresses(List<Address> addresses)
    {
        this.addresses = addresses;
    }

    public List<Address> getAddresses()
    {
        return addresses;
    }

    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }

    public List<Order> getOrders()
    {
        return orders;
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
