package shareMarketAssesment;

import java.util.*;

interface Tradeable {
	void buyStock(String stockId, int quantity, Market market) throws Exception;

	void sellStock(String stockId, int quantity, Market market) throws Exception;
}

//Custom Exception: InsufficientSharesException
class InsufficientSharesException extends Exception {
	public InsufficientSharesException(String message) {
		super(message);
	}
}

//Custom Exception: StockNotFoundException
class StockNotFoundException extends Exception {
	public StockNotFoundException(String message) {
		super(message);
	}
}

//Custom Exception: InsufficientMarketSharesException
class InsufficientMarketSharesException extends Exception {
	public InsufficientMarketSharesException(String message) {
		super(message);
	}
}

//Stock class
class Stock {
	private final String stockId;
	private final String stockName;
	private final double pricePerShare;
	private int availableShares;

	public Stock(String stockId, String stockName, double pricePerShare, int availableShares) {
		this.stockId = stockId;
		this.stockName = stockName;
		this.pricePerShare = pricePerShare;
		this.availableShares = availableShares;
	}

	public synchronized void reduceShares(int quantity) throws InsufficientMarketSharesException {
		if (quantity > availableShares) {
			throw new InsufficientMarketSharesException("Market has only " + availableShares + " shares of " + stockId);
		}
		availableShares -= quantity;
	}

	public synchronized void increaseShares(int quantity) {
		availableShares += quantity;
	}

	public String getStockId() {
		return stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public double getPricePerShare() {
		return pricePerShare;
	}

	public synchronized int getAvailableShares() {
		return availableShares;
	}

	@Override
	public String toString() {
		return stockName + " (" + stockId + ") - $" + pricePerShare + " | Available Shares: " + availableShares;
	}
}

//Market class
class Market {
	private final Map<String, Stock> stockMap = new HashMap<>();

	public synchronized void addStock(Stock stock) {
		stockMap.put(stock.getStockId(), stock);
	}

	public synchronized Stock getStock(String stockId) throws StockNotFoundException {
		if (!stockMap.containsKey(stockId)) {
			throw new StockNotFoundException("Stock ID " + stockId + " does not exist in the market.");
		}
		return stockMap.get(stockId);
	}

	public Map<String, Stock> getAllStocks() {
		return stockMap;
	}
}

//Trader class
class Trader implements Tradeable, Runnable {
	private final int traderId;
	private final String name;
	private final Market market;
	private final Map<String, Integer> portfolio = new HashMap<>();
	private final String[] tradingStocks;

	public Trader(int traderId, String name, Market market, String[] tradingStocks) {
		this.traderId = traderId;
		this.name = name;
		this.market = market;
		this.tradingStocks = tradingStocks;
	}

	@Override
	public void buyStock(String stockId, int quantity, Market market) throws Exception {
		Stock stock = market.getStock(stockId);
		stock.reduceShares(quantity);
		synchronized (this) {
			portfolio.put(stockId, portfolio.getOrDefault(stockId, 0) + quantity);
		}
		System.out.println(name + " bought " + quantity + " shares of " + stock.getStockName());
	}

	@Override
	public void sellStock(String stockId, int quantity, Market market) throws Exception {
		synchronized (this) {
			if (!portfolio.containsKey(stockId) || portfolio.get(stockId) < quantity) {
				throw new InsufficientSharesException(name + " doesn't have enough shares of " + stockId + " to sell.");
			}
			portfolio.put(stockId, portfolio.get(stockId) - quantity);
		}
		Stock stock = market.getStock(stockId);
		stock.increaseShares(quantity);
		System.out.println(name + " sold " + quantity + " shares of " + stock.getStockName());
	}

	@Override
	public void run() {
		for (String stockId : tradingStocks) {
			try {
				buyStock(stockId, 5, market);
				Thread.sleep(100); // Simulate processing time
				sellStock(stockId, 2, market);
			} catch (Exception e) {
				System.err.println("Error in " + name + "'s transaction: " + e.getMessage());
			}
		}
	}

	public void printPortfolio() {
		System.out.println("Portfolio of " + name + ":");
		synchronized (this) {
			for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
				System.out.println("  " + entry.getKey() + ": " + entry.getValue() + " shares");
			}
		}
	}
}

//Main class
public class ShareMarketTradingSystem {
	public static void main(String[] args) throws InterruptedException {

		Market market = new Market();
		market.addStock(new Stock("GOOG", "Google", 2800.00, 100));
		market.addStock(new Stock("AAPL", "Apple", 170.00, 120));
		market.addStock(new Stock("AMZN", "Amazon", 3500.00, 90));

		String[] stockIds = { "GOOG", "AAPL", "AMZN" };

		Trader trader1 = new Trader(1, "Kranthi", market, stockIds);
		Trader trader2 = new Trader(2, "Ramesh", market, stockIds);
		Trader trader3 = new Trader(3, "Mahesh", market, stockIds);

		Thread t1 = new Thread(trader1);
		Thread t2 = new Thread(trader2);
		Thread t3 = new Thread(trader3);

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		System.out.println("\n====== FINAL PORTFOLIOS ======");
		trader1.printPortfolio();
		trader2.printPortfolio();
		trader3.printPortfolio();

		System.out.println("\n====== REMAINING MARKET STOCKS ======");
		for (Stock stock : market.getAllStocks().values()) {
			System.out.println(stock);
		}
	}
}
