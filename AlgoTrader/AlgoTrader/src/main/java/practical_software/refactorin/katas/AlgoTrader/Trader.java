package practical_software.refactorin.katas.AlgoTrader;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
				Session session = null;
				Transaction tx = null;
				try {
					session = HibernateSessionGenerator.openSession();
					tx = session.getTransaction();
					tx.begin();
				
					session.saveOrUpdate(stock);
				
					tx.commit();
					session.flush();
				} finally {
					if (session != null) {
						session.clear();
						session.close();
					}
				}
				
				((StocksMarketApi) _stocksMarketApi).sendSellCommand(stock);
			}
		}
	}

}
