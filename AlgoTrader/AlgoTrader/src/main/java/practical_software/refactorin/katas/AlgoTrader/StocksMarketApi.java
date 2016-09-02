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

	public void sell(Stock stock) throws ClientProtocolException, IOException {
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

		sendSellCommand(stock);
	}

	private void sendSellCommand(Stock stock) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet("http://www.somestockmarket.com/api/sell?id=" + stock.getId());
		client.execute(get);
	}

}
