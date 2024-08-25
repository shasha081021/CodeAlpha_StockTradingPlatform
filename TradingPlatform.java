import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Stock {
    private String ticker;
    private String companyName;
    private double price;

    public Stock(String ticker, String companyName, double price) {
        this.ticker = ticker;
        this.companyName = companyName;
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ticker + " (" + companyName + ") - $" + price;
    }
}

class Market {
    private Map<String, Stock> stocks = new HashMap<>();

    public void addStock(Stock stock) {
        stocks.put(stock.getTicker(), stock);
    }

    public Stock getStock(String ticker) {
        return stocks.get(ticker);
    }

    public void simulateMarketChange() {
        for (Stock stock : stocks.values()) {
            // Simple simulation of price change
            double newPrice = stock.getPrice() * (0.95 + Math.random() * 0.1);
            stock.setPrice(Math.round(newPrice * 100.0) / 100.0); // Round to 2 decimal places
        }
    }

    public void displayMarketData() {
        System.out.println("Market Data:");
        for (Stock stock : stocks.values()) {
            System.out.println(stock);
        }
    }
}

class Portfolio {
    private Map<String, Integer> ownedStocks = new HashMap<>();
    private double cash;

    public Portfolio(double initialCash) {
        this.cash = initialCash;
    }

    public double getCash() {
        return cash;
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (cash >= cost) {
            ownedStocks.put(stock.getTicker(), ownedStocks.getOrDefault(stock.getTicker(), 0) + quantity);
            cash -= cost;
            System.out.println("Bought " + quantity + " shares of " + stock.getTicker());
        } else {
            System.out.println("Insufficient funds to buy " + quantity + " shares of " + stock.getTicker());
        }
    }

    public void sellStock(Stock stock, int quantity) {
        int ownedQuantity = ownedStocks.getOrDefault(stock.getTicker(), 0);
        if (ownedQuantity >= quantity) {
            ownedStocks.put(stock.getTicker(), ownedQuantity - quantity);
            cash += stock.getPrice() * quantity;
            System.out.println("Sold " + quantity + " shares of " + stock.getTicker());
        } else {
            System.out.println("Insufficient shares to sell");
        }
    }

    public void displayPortfolio(Market market) {
        System.out.println("Portfolio:");
        for (Map.Entry<String, Integer> entry : ownedStocks.entrySet()) {
            Stock stock = market.getStock(entry.getKey());
            int quantity = entry.getValue();
            double value = stock.getPrice() * quantity;
            System.out.println(stock.getTicker() + ": " + quantity + " shares, Value: $" + value);
        }
        System.out.println("Cash: $" + cash);
    }
}

public class TradingPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Market market = new Market();
        Portfolio portfolio = new Portfolio(10000); // Initial cash

        // Adding some stocks to the market
        market.addStock(new Stock("AAPL", "Apple Inc.", 150.00));
        market.addStock(new Stock("GOOGL", "Alphabet Inc.", 2700.00));
        market.addStock(new Stock("AMZN", "Amazon.com Inc.", 3300.00));

        while (true) {
            System.out.println("\n1. View Market Data\n2. Buy Stock\n3. Sell Stock\n4. View Portfolio\n5. Simulate Market Change\n6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    market.displayMarketData();
                    break;
                case 2:
                    System.out.print("Enter stock ticker: ");
                    String tickerBuy = scanner.next().toUpperCase();
                    Stock stockToBuy = market.getStock(tickerBuy);
                    if (stockToBuy != null) {
                        System.out.print("Enter quantity: ");
                        int quantityBuy = scanner.nextInt();
                        portfolio.buyStock(stockToBuy, quantityBuy);
                    } else {
                        System.out.println("Stock not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter stock ticker: ");
                    String tickerSell = scanner.next().toUpperCase();
                    Stock stockToSell = market.getStock(tickerSell);
                    if (stockToSell != null) {
                        System.out.print("Enter quantity: ");
                        int quantitySell = scanner.nextInt();
                        portfolio.sellStock(stockToSell, quantitySell);
                    } else {
                        System.out.println("Stock not found");
                    }
                    break;
                case 4:
                    portfolio.displayPortfolio(market);
                    break;
                case 5:
                    market.simulateMarketChange();
                    System.out.println("Market prices have changed.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
