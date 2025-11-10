
package productsalesapplication;


public abstract class ProductSales implements IProductSales {

    public ProductSales() {
    }
    
    
    //Data
    
    int productSales, totalSales, salesOverLimit, salesUnderLimit, productProcessed;
    double averageSales;

    // Constructor
    public ProductSales(int productSales, int totalSales, int salesOverLimit, int salesUnderLimit, int productProcessed, double averageSales) {
        this.productSales = productSales;
        this.totalSales = totalSales;
        this.salesOverLimit = salesOverLimit;
        this.salesUnderLimit = salesUnderLimit;
        this.productProcessed = productProcessed;
        this.averageSales = averageSales;
    }
    
    
    //Getter

    public int getProductSales() {
        return productSales;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public int getSalesOverLimit() {
        return salesOverLimit;
    }

    public int getSalesUnderLimit() {
        return salesUnderLimit;
    }

    public int getProductProcessed() {
        return productProcessed;
    }

    public double getAverageSales() {
        return averageSales;
    }
    
    //Setter

    public void setProductSales(int productSales) {
        this.productSales = productSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public void setSalesOverLimit(int salesOverLimit) {
        this.salesOverLimit = salesOverLimit;
    }

    public void setSalesUnderLimit(int salesUnderLimit) {
        this.salesUnderLimit = salesUnderLimit;
    }

    public void setProductProcessed(int productProcessed) {
        this.productProcessed = productProcessed;
    }

    public void setAverageSales(double averageSales) {
        this.averageSales = averageSales;
    }
    
    
}
