package tutoSpringBoot.domain;

public class Product {

    private Integer id;
    private String name;
    private Double prize;
    private Integer stock;

    // Constructor vacío para Jackson JSON
    public Product() {
        
    }

    public Product(Integer id, String name, Double prize, Integer stock) {
        this.id = id;
        this.name = name;
        this.prize = prize;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public Double getprize() {
        return prize;
    }

    public void setprize(Double prize) {
        this.prize = prize;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
