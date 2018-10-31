package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Customer implements Serializable
{
    private Long customerId;
    private String fullName;
    private String email;
    private String password;
    
    private List<Transaction> transactions;

    
    
    public Customer() 
    {
        transactions = new ArrayList<>();
    }

    
    
    public Customer(Long customerId, String fullName, String email, String password) 
    {
        this();
        
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
    
    
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (this.customerId != null ? this.customerId.hashCode() : 0);
        
        return hash;
    }

    
    
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof Customer)) 
        {
            return false;
        }
        
        Customer other = (Customer) object;
        
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) 
        {
            return false;
        }
        
        return true;
    }

    
    
    @Override
    public String toString() 
    {
        return "entity.Customer[ customerId=" + this.customerId + " ]";
    }
    
    
    
    public void addTransaction(Transaction transaction)
    {
        if(!this.transactions.contains(transaction))
        {
            this.transactions.add(transaction);
        }
    }
    
    
    
    public void removeTransaction(Transaction transaction)
    {
        if(this.transactions.contains(transaction))
        {
            this.transactions.remove(transaction);
        }
    }

    
    
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
}
