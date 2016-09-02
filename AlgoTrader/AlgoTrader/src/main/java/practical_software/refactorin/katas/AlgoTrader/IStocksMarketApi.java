package practical_software.refactorin.katas.AlgoTrader;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface IStocksMarketApi {

	void sell(Stock stock) throws ClientProtocolException, IOException;

}