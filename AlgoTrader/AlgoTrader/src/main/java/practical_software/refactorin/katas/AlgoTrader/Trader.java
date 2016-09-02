package practical_software.refactorin.katas.AlgoTrader;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

public class Trader {

	private IStocksRepoistory _stocksRepository;
	private IStocksMarketApi _stocksMarketApi;
	
	public Trader(IStocksRepoistory stocksRepository, IStocksMarketApi stocksMarketApi) {
		_stocksRepository = stocksRepository;
		_stocksMarketApi = stocksMarketApi;
	}

	public void sellStocks() throws ClientProtocolException, IOException {		
		List<Stock> stocks = _stocksRepository.getAllStocks();
		for (Stock stock : stocks) {
			if(stock.shouldBeSold()){
				_stocksMarketApi.sell(stock);
			}
		}
	}

}
