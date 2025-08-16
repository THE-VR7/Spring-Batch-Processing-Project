package com.batch.example.BootBatch.config;

import com.batch.example.BootBatch.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) throws Exception {
        //transform logic goes here
        // calculate kareinge discounted price ko

        try {
            System.out.println(item.getDescription());
            int discountPercentage = Integer.parseInt(item.getDiscount().trim());
            double originalPrice = Double.parseDouble(item.getPrice().trim());
            double discount = ((double) discountPercentage / 100) * originalPrice;
            double finalPrice = originalPrice - discount;
            item.setDiscountedPrice("" + finalPrice);
        } catch (NumberFormatException ex) {
//            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return item;
    }
}
