package com.pluralsight.services;

import com.pluralsight.model.order.OrderItem;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static com.pluralsight.model.order.Order.getItems;

/**
 * Handles generating and saving order receipts to text files.
 */
public class ReceiptBuilder {

    /**
     * Processes a single order item to get its receipt representation.
     * @param order the order item to process
     */
    public void getReceiptString(OrderItem order) {

    }

    /**
     * Automatically builds, formats, and saves the active order receipt to a localized text file.
     */
    public static void saveReceiptString() {

        try {
            LocalDateTime date = LocalDateTime.now();

            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");

            String formattedDate = date.format(myFormatObj);

            FileWriter fr = new FileWriter("src/main/java/com/pluralsight/Receipt/" + formattedDate + ".txt");

            fr.write("""
                    ╔══════════════════════════════════════════════════════╗
                    ║                 Sayed's Sandwich Shop                ║
                    ║                 2245 8th st Washington DC            ║
                    ║                 555-989-4532                         ║
                    ╚══════════════════════════════════════════════════════╝
                    
                    """ + "\n"
            );

            //runa different method
            double total = 0;
            for (OrderItem o : getItems()) {
                fr.write(o.forReceipt() + "\n");
                total += o.getPrice();
            }

            fr.write("Total:  " + String.valueOf(total));

            fr.close();

        } catch (IOException e) {
            e.getMessage();
        }
    }
}