package com.group13.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group13.data.DestinationDB;
import com.group13.data.HotelDB;
import com.group13.model.Destination;
import com.group13.model.DestinationViewModel;
import com.group13.model.Hotel;
import com.group13.model.Room;


//@WebServlet("/DestinationController")
public class DestinationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DestinationDB destinationDb;  
    HotelDB hotelDb;
    
    public DestinationController() {
        super();
        destinationDb = new DestinationDB();
        hotelDb = new HotelDB();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int desId = Integer.parseInt(request.getParameter("id"));
		
		Destination destination = destinationDb.getDestination(desId);
		List<Hotel> hotelList = destinationDb.getHotelList(desId);
		List<DestinationViewModel> viewModels = new ArrayList<DestinationViewModel>();
		
		for(int i=0; i<hotelList.size(); i++) {
			Hotel hotel = hotelList.get(i);
			Room room = hotelDb.getHotelRoom(hotelList.get(i).getRoomId());
			List<String> offers = hotelDb.getHotelOffers(hotelList.get(i).getHotelId());
			String image = hotelDb.getHotelImages(hotel.getHotelId()).get(0);
			viewModels.add(new DestinationViewModel(hotel, room, offers, image));
		}
		
		request.setAttribute("destination", destination);
		request.setAttribute("viewModels", viewModels);
		getServletContext().getRequestDispatcher("/destination.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
