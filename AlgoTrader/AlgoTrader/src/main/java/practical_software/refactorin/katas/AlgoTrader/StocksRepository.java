package practical_software.refactorin.katas.AlgoTrader;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StocksRepository implements IStocksRepoistory {

	public List<Stock> getAllStocks() {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public void delete(Stock stock) throws Exception {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionGenerator.openSession();
            tx = session.getTransaction();
            tx.begin();

            session.delete(stock);

            tx.commit();
            session.flush();
        } finally {
            if (session != null) {
                session.clear();
                session.close();
            }
        }
    }
}
