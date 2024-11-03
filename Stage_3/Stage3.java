
public class Stage3 {

    
    public static void main(String[] args) {
        Individual emp1 = new Staff("John", "123", "456", "Manager");
        Individual emp2 = new Staff("Alton", "444", "654", "Dish Washer");
        Individual emp3 = new Staff("John", "333", "744", "Buser");
        
        Individual table1 = new Customer(1,"Burger", "Paola", "12324455");
        Individual table2 = new Customer(2,"Eggs", "Liz", "2332344");
        
        Waiter wait1 = new Waiter("Paul", "234", "789");
        Waiter wait2 = new Waiter("Rigo", "666", "987");
        Waiter wait3 = new Waiter("Fred", "765", "098");
        
        Cook cook1 = new Cook("Esther", "990", "4432");
        Cook cook2 = new Cook("Clive", "6654", "11123");
        
        Inventory foodItem1 = new Inventory("Egg Sando", 10, 8.99f);
        Inventory foodItem2 = new Inventory("BLT", 10, 12.99f);
        Inventory foodItem3 = new Inventory("Avo Toast", 10, 15.99f);
        
        Inventory foodItem4 = new Inventory("Coffee", 10, 8.99f);
        Inventory foodItem5 = new Inventory("Matcha", 10, 8.99f);
        Inventory foodItem6 = new Inventory("Chai", 10, 8.99f);
        
        Inventory foodItem7 = new Inventory("Croissant", 5, 9.99f);
        Inventory foodItem8 = new Inventory("Coffee Cake", 10, 6.99f);
     
    }
    
}
