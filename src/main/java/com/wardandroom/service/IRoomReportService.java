package com.wardandroom.service;

import com.wardandroom.entities.RoomReport;

public interface IRoomReportService {
	public boolean createRoomReport(RoomReport roomreport) ;
	
	public boolean updateRoomReport(RoomReport roomreport);
	
	public RoomReport findById(int id);

}
