package practical_software.refactorin.katas.AlgoTrader;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClientProtocolException, IOException
    {
        Trader trader = new Trader(new StocksRepository(), new StocksMarketApi());
        trader.sellStocks();
    }
}
