package services;

import carCodes.Codes;

import java.util.HashMap;
import java.util.Map;

public class ServicesImp {


    public void startService(String car, String[] n) {
        HashMap<Object,Object> hm=new HashMap<>();

            hm.put("BS01", "Basic Servicing");
            hm.put("EF01", "Engine Fixing");
            hm.put("CF01", "Clutch Fixing");
            hm.put("BF01", "Brake Fixing");
            hm.put("GF01", "Gear Fixing");


            Codes ser = new Codes();
            switch (car) {
                case "Hatchback" -> ser.setValues(2000, 5000, 2000, 1000, 3000);
                case "Sedan" -> ser.setValues(4000, 8000, 4000, 1500, 6000);
                case "SUV" -> ser.setValues(5000, 10000, 6000, 2500, 8000);
            }
            int totalBill = 0;
            for (String e : n) {
                System.out.println("Charges for " + hm.get(e) + " – ₹" + ser.getValues(e));
                totalBill = totalBill + ser.getValues(e);
            }
            System.out.println("Total Bill – ₹" + totalBill);
            if (totalBill > 10000) {
                System.out.println("Complimentary cleaning provided.");
            }
        }

}
