package practical_software.refactorin.katas.AlgoTrader;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StocksMarketApi implements IStocksMarketApi {

	public void sendSellCommand(Stock stock) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet("http://www.somestockmarket.com/api/sell?id=" + stock.getId());
		client.execute(get);
	}

}
