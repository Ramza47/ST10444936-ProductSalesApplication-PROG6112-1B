
package productsalesapplication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ProductSalesApplicationTest {
    
    public ProductSalesApplicationTest() {
    }

    @Test
    public void GetSalesOverLImit_ReturnsNumberOfSales() {
        String overLimitString = app.getSalesOverLimit(app.productSales, Pro.limit);
        
        // Count the number of sales over the limit (split by spaces)
        int count = 0;
        for (String line : overLimitString.split("\n")) {
            // Ignore lines that start with "Year"
            if (!line.startsWith("Year") && !line.isEmpty()) {
                String[] numbers = line.trim().split("\\s+");
                count += numbers.length;
            }
        }

        // Expected over-limit numbers: 700, 600 => total 2
        assertEquals(2, count, "There should be 2 sales over the limit");
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        
        String underLimitString = app.getSalesUnderLimit(app.productSales, app.limit);

        // Count the number of sales under the limit (split by spaces)
        int count = 0;
        for (String line : underLimitString.split("\n")) {
            // Ignore lines that start with "Year"
            if (!line.startsWith("Year") && !line.isEmpty()) {
                String[] numbers = line.trim().split("\\s+");
                count += numbers.length;
            }
        }

        // Expected under-limit numbers: 300,150,250,200 => total 4
        assertEquals(4, count, "There should be 4 sales under the limit");
    }

}
