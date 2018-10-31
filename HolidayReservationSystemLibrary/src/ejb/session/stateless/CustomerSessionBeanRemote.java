package ejb.session.stateless;

import entity.Customer;
import util.exception.InvalidLoginCredentialException;



public interface CustomerSessionBeanRemote
{    
    public Customer login(String email, String password) throws InvalidLoginCredentialException;
}