package shoppinglist.controller;

import shoppinglist.view.*;
import shoppinglist.model.*;

public class AppController {
    public static void main(String[] args) {
        ShowItemView view = new ShowItemView();
        Items items       = new Items();
        
        MainController mainController = new MainController(view, items);
        
        // initiate mainController
        mainController.initController();
        
        // initiate mainController in view
        view.initController(mainController);
    }
}
