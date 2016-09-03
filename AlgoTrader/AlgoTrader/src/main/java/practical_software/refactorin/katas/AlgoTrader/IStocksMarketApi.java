package practical_software.refactorin.katas.AlgoTrader;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface IStocksMarketApi {
	void sendSellCommand(Stock stock) throws ClientProtocolException, IOException;

//	void sell(Stock stock) throws ClientProtocolException, IOException;

}