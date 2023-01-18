package shoppinglist.controller;

import shoppinglist.view.*;
import shoppinglist.model.*;

public class App {
    public static void main(String[] args) {
        View view   = new View();
        Items items = new Items();
        
        Controller controller = new Controller(view, items);
        
        // initiate controller
        controller.initController();
        
        // initiate controller in view
        view.initController(controller);
    }
}
