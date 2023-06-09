package com.ltp.globalsuperstore;

import org.springframework.stereotype.Controller;

@Controller
public class InventoryForm {
 
    public String getForm(){
        
        return "inventory";
    }
}
