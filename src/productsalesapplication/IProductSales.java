
package productsalesapplication;


interface IProductSales {
    int[]GetProductSales();
    int GetTotalSales();
    int GetSalesOverLimit();
    int GetSalesUnderLimit();
    int GetProductProcessed();
    double GetAverageSales();
}
