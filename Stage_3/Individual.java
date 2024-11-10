//this is the Individual Class
public class Individual {
    private String name;
    private String role;

    //the individual constructor initializes the instance variables
    public Individual(String name, String role) {
        this.name = name;
        this.role = role;
    }

    //this method gets the name and returns the name
    public String getName() {
        return name;
    }

    //this method gets the role and returns the role
    public String getRole() {
        return role;
    }

    //this method sets the name.
    public void setName(String name) {
        this.name = name;
    }

    //this method sets the role.
    public void setRole(String role) {
        this.role = role;
    }
}
