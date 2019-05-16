package com.tryam.study.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Component("user")
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String secondName;

    @Column
    @NotNull
    private String sex;

    @Column
    @NotNull
    private Integer age;

    @Column
    @NotNull
    private String country;

    @Column
    @NotNull
    private String city;

    @Column
    @Email
    private String emailAddress;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(getId(), user.getId())
                .append(getFirstName(), user.getFirstName())
                .append(getSecondName(), user.getSecondName())
                .append(getSex(), user.getSex())
                .append(getAge(), user.getAge())
                .append(getCountry(), user.getCountry())
                .append(getCity(), user.getCity())
                .append(getEmailAddress(), user.getEmailAddress())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getFirstName())
                .append(getSecondName())
                .append(getSex())
                .append(getAge())
                .append(getCountry())
                .append(getCity())
                .append(getEmailAddress())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", firstName='" + firstName +
                "', secondName='" + secondName +
                "', sex='" + sex +
                "', age=" + age +
                ", country='" + country +
                "', city='" + city +
                "', emailAddress='" + emailAddress +
                "'}";
    }

}