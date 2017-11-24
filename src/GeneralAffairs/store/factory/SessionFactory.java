package GeneralAffairs.store.factory;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {

	private static SessionFactory instance;
	private static SqlSessionFactory sqlSessionFactory;
	private static final String resource = "MoneyManager/mybatis-config.xml";

	private SessionFactory() {
	}

	public static SessionFactory getInstance() {
		if (instance == null) {
			instance = new SessionFactory();
		}
		return instance;
	}

	public SqlSession getSession() {
		if (sqlSessionFactory == null) {
			Reader reader = null;
			try {
				reader = Resources.getResourceAsReader(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		return sqlSessionFactory.openSession();
	}
}
