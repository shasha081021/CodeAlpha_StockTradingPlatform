# Stock Trading Platform

## Overview

The Stock Trading Platform is a Java-based console application that simulates a simple stock trading environment. Users can view market data, buy and sell stocks, manage their portfolio, and simulate market changes. This project demonstrates fundamental concepts in object-oriented programming, data structures, and basic financial transactions.

## Features

- **Market Data**: View current stock prices and company information.
- **Buy and Sell Stocks**: Purchase or sell stocks from the market.
- **Portfolio Management**: View the current portfolio, including owned stocks and cash balance.
- **Simulate Market Changes**: Apply random changes to stock prices to simulate market fluctuations.

## Classes

### Stock

Represents a stock in the market.

- **Attributes**:
  - `ticker`: The stock ticker symbol (e.g., AAPL).
  - `companyName`: The name of the company.
  - `price`: The current price of the stock.

- **Methods**:
  - `getTicker()`: Returns the ticker symbol.
  - `getPrice()`: Returns the current price.
  - `setPrice(double price)`: Sets a new price for the stock.
  - `toString()`: Returns a string representation of the stock.

### Market

Manages the collection of stocks and simulates market changes.

- **Methods**:
  - `addStock(Stock stock)`: Adds a stock to the market.
  - `getStock(String ticker)`: Retrieves a stock by its ticker symbol.
  - `simulateMarketChange()`: Randomly changes stock prices.
  - `displayMarketData()`: Displays current market data.

### Portfolio

Manages the user's stock portfolio and cash balance.

- **Methods**:
  - `getCash()`: Returns the current cash balance.
  - `buyStock(Stock stock, int quantity)`: Buys a specified quantity of stock.
  - `sellStock(Stock stock, int quantity)`: Sells a specified quantity of stock.
  - `displayPortfolio(Market market)`: Displays the current portfolio and cash balance.

### TradingPlatform

The main class that drives the application and provides a menu interface for the user.

- **Methods**:
  - `main(String[] args)`: Contains the main loop of the application, handling user inputs and executing corresponding actions.

## Usage

1. **Compile and Run**:
   - Compile the program using `javac TradingPlatform.java`.
   - Run the program using `java TradingPlatform`.

2. **Interact with the Program**:
   - Choose from the provided options to view market data, buy/sell stocks, view your portfolio, or simulate market changes.

Selecting 1 will display the current market data.
Selecting 2 will prompt for stock ticker and quantity to buy.
Selecting 3 will prompt for stock ticker and quantity to sell.
Selecting 4 will display your portfolio.
Selecting 5 will simulate market price changes.
Selecting 6 will exit the program.

Notes
Ensure you have Java installed to run this application.
Modify stock data and initial cash balance as needed in the TradingPlatform class.

## Example

```plaintext
1. View Market Data
2. Buy Stock
3. Sell Stock
4. View Portfolio
5. Simulate Market Change
6. Exit

