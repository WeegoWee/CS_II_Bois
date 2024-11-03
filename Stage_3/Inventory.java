public class Inventory{
    private String food;
    private String drinks;
    private short totalFood;
    private short totalDrinks;
    private Menu items;

    public Inventory(String food, short totalFood, Menu items){
        this.food = food;
        this.totalFood = totalFood;
        this.items = items;
    }

    public Inventory(String drinks, short totalDrinks, Inventory items){
        this.drinks = drinks;
        this.totalDrinks = totalDrinks;
        this.items = items.items;
    }

    public String getFood(){
        return food;
    }

    public String getDrink(){
        return drinks;
    }

    public short getTotalFood(){
        return totalFood;
    }

    public short getTotalDrink(){
        return totalDrinks;
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

    public void setTotalDrink(short totalDrinks){
        this.totalDrinks = totalDrinks;
    }
}
