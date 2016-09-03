package practical_software.refactorin.katas.AlgoTrader;

import java.util.List;

public class Trader {

    private IStocksRepoistory _stocksRepository;
    private IStocksMarketApi _stocksMarketApi;

    public Trader(IStocksRepoistory stocksRepository, IStocksMarketApi stocksMarketApi) {
        _stocksRepository = stocksRepository;
        _stocksMarketApi = stocksMarketApi;
    }

    public void sellStocks() throws Exception {
        List<Stock> stocks = _stocksRepository.getAllStocks();
        for (Stock stock : stocks) {
            if (stock.shouldBeSold()) {
                _stocksRepository.delete(stock);

                ((StocksMarketApi) _stocksMarketApi).sendSellCommand(stock);
            }
        }
    }

}
