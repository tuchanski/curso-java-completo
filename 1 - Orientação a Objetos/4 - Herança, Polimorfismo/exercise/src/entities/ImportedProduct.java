package entities;

public class ImportedProduct extends Product{

    private Double customsFee;

    public ImportedProduct(){}

    public ImportedProduct(String name, Double price, Double customsFee){
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    public double totalPrice(){
        return price = price + customsFee;
    }

    @Override
    public final String priceTag(){
        return "Imported product " + name + " - $" + price + " - Customs fee: $" + customsFee + " - Total: $" + totalPrice();
    }
}
