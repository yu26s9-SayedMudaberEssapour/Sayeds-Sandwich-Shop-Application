package com.pluralsight.services;

import com.pluralsight.model.order.OrderItem;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static com.pluralsight.model.order.Order.getItems;

public class ReceiptBuilder {


    public void getReceiptString(OrderItem order) {

    }

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


//    public String receipt() {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("===== ORDER RECEIPT =====\n");
//
//        for (OrderItem item : items) {
//            sb.append(item.getDescription())
//                    .append(" - $")
//                    .append(String.format("%.2f", item.getPrice()))
//                    .append("\n");
//        }
//
//        sb.append("------------------------\n");
//        sb.append("TOTAL: $")
//                .append(String.format("%.2f", calculateTotal()));
//
//        return sb.toString();
//    }
}
