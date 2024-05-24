/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon_assignment;

/**
 *
 * @author user
 */
class Pokemon {
    private String name;
    private String type;
    private int level;
    
    // Constructor
    public Pokemon(String name, String type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }
    
    // Getter method for name
    public String getName() {
        return name;
    }
    
    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter method for type
    public String getType() {
        return type;
    }
    
    // Setter method for type
    public void setType(String type) {
        this.type = type;
    }
    
    // Getter method for level
    public int getLevel() {
        return level;
    }
    
    // Setter method for level
    public void setLevel(int level) {
        this.level = level;
    }
}
