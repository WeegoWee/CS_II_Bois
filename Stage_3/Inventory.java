public class Inventory{
    private String food;
    private String drinks;
    private int totalFood;
    private float price;

    public Inventory(String food, int totalFood, float price) {
        this.food = food;
        this.totalFood = totalFood;
        this.price = price;
    }

    public String getFood(){
        return food;
    }

    public String getDrink(){
        return drinks;
    }

    public int getTotalFood(){
        return totalFood;
    }

    public void addFood(String food){
        this.food = food;
    }

    public void addDrink(String drink){
        this.drinks = drink;
    }

    public void setTotalFood(short totalFood){
        this.totalFood = totalFood;
    }
    
    

}
