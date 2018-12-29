package p.pklovestar.apiretrofitlibrary;

import java.io.Serializable;

public class Produce implements Serializable {
    public String id;
    public String produce;
    public Integer price;

    public Produce() {
    }

    public Produce(String produce, Integer price) {
        this.produce = produce;
        this.price = price;
    }

    public Produce(String id, String produce, Integer price) {
        this.id = id;
        this.produce = produce;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
