package com.bravi.facade;

import com.bravi.context.AppContext;

public class OperationsFacadeImpl implements OperationsFacade {

    private final AppContext appContext;

    public OperationsFacadeImpl() {
        this.appContext = new AppContext();
    }

    @Override
    public void loadXMLData() {
        appContext.getXmlDataLoader().loadXMLFilesData();
    }

    @Override
    public void showClientsDataSaved() {
        appContext.getClientServiceInstance().showAllClients();
    }

    @Override
    public void showClientMoreMoneySpent() {
        appContext.getClientServiceInstance().showClientMoreMoneySpent();

    }

    @Override
    public void showClientMoreOrdersMade() {
        appContext.getClientServiceInstance().showClientHasMoreOrders();
    }

    @Override
    public void showProductsDataSaved() {
        appContext.getProductServiceInstance().showAllProducts();
    }

    @Override
    public void showOrdersDataSaved() {
        appContext.getOrderServiceInstance().showAllOrders();
    }
}
