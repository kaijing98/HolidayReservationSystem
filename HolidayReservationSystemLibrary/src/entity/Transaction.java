package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Transaction implements Serializable
{
    private Long transactionId;
    private BigDecimal totalAmount;
    private Date transactionDateTime;
    private Customer customer;
    
    private List<ItineraryItem> itineraryItems;

    
    
    public Transaction() 
    {
        itineraryItems = new ArrayList<>();
    }

    
    
    public Transaction(Long transactionId, BigDecimal totalAmount, Date transactionDateTime, Customer customer) 
    {
        this();
        
        this.transactionId = transactionId;
        this.totalAmount = totalAmount;
        this.transactionDateTime = transactionDateTime;
        
        setCustomer(customer);
    }
    
    
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (this.transactionId != null ? this.transactionId.hashCode() : 0);
        
        return hash;
    }

    
    
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof Transaction)) 
        {
            return false;
        }
        
        Transaction other = (Transaction) object;
        
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) 
        {
            return false;
        }
        
        return true;
    }

    
    
    @Override
    public String toString() 
    {
        return "entity.Transaction[ transactionId=" + this.transactionId + " ]";
    }

    
    
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(Date transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) 
    {
        if(this.customer != null)
        {
            this.customer.removeTransaction(this);
        }
        
        this.customer = customer;
        
        if(this.customer != null)
        {
            this.customer.addTransaction(this);
        }
    }

    public List<ItineraryItem> getItineraryItems() {
        return itineraryItems;
    }

    public void setItineraryItems(List<ItineraryItem> itineraryItems) {
        this.itineraryItems = itineraryItems;
    }
    
    
}