package com.tryam.study.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Component("account")
@Entity
@Table(name = "accounts")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    @Size(min=2, max=50)
    @NotNull
    private String login;

    @Column
    private String password;

    @OneToOne(optional = false, mappedBy = "account")
    private User user;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getLogin(), account.getLogin())
                .append(getPassword(), account.getPassword())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(getLogin())
                .append(getPassword())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Account{" +
                "Id=" + Id +
                ", login='" + login +
                "', password='" + password +
                "', user=" + user +
                "'}";
    }
}