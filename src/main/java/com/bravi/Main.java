package com.bravi;

import com.bravi.facade.OperationsFacade;
import com.bravi.facade.OperationsFacadeImpl;

public class Main {

    public static void main(String[] args) {
        OperationsFacade operationsFacade = new OperationsFacadeImpl();

        operationsFacade.loadXMLData();
        operationsFacade.showClientsDataSaved();
        operationsFacade.showProductsDataSaved();
        operationsFacade.showOrdersDataSaved();
        operationsFacade.showClientMoreMoneySpent();
        operationsFacade.showClientMoreOrdersMade();
    }

}