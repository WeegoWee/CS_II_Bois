
public class Individual {
    
    private String name;
    private String contactInfo;
    
    public Individual(String name, String contactInfo){
        this.name = name;
        this.contactInfo = contactInfo;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInfo;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInfo = contactInformation;
    }
    
    public void showInfo(){
        
    }
}
