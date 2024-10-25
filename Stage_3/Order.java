
class Order{
    private String orderID;
    private Customer customer;
    
    public Order(String orderID, Customer customer)
    {
        this.orderID = orderID;
        Customer customer = new Customer();
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void addOrder()
    {
        
    }
    
}
