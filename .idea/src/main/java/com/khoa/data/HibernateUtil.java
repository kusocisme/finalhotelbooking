package com.khoa.data;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.khoa.model.Destination;
import com.khoa.model.DestinationHotels;
import com.khoa.model.Hotel;
import com.khoa.model.HotelImages;
import com.khoa.model.HotelOffers;
import com.khoa.model.Room;
import com.khoa.model.RoomOffers;
import com.khoa.model.User;
import com.khoa.model.Wishlist;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hotelbooking");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "123456789");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update"); 

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Hotel.class);
				configuration.addAnnotatedClass(Room.class);
			    configuration.addAnnotatedClass(Destination.class);
			    configuration.addAnnotatedClass(DestinationHotels.class);
			    configuration.addAnnotatedClass(HotelOffers.class);
			    configuration.addAnnotatedClass(RoomOffers.class);
			    configuration.addAnnotatedClass(HotelImages.class);
			    configuration.addAnnotatedClass(Wishlist.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
