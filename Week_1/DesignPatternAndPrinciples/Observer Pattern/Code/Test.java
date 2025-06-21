public class Test {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp("InvestorMobile");
        Observer webApp = new WebApp("InvestorWeb");
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);
        stockMarket.setStockPrice("Apple", 189.32);
        System.out.println();
        stockMarket.setStockPrice("Google", 2754.23);
        System.out.println();
        stockMarket.removeObserver(webApp);
        stockMarket.setStockPrice("Microsoft", 703.15);
    }
}
