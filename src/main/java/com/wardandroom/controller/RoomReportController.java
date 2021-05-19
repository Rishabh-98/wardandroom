
package com.wardandroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wardandroom.entities.RoomReport;
import com.wardandroom.exception.RoomReportException;
import com.wardandroom.service.RoomReportServiceImpl;

@RestController

@RequestMapping("/api/roomreport/")
public class RoomReportController {

	@Autowired
	private RoomReportServiceImpl roomreportServiceImpl;

	@PostMapping("/")
	public boolean createRoomReport(@RequestBody RoomReport roomreport) {

		RoomReportServiceImpl.createRoomReport(roomreport);
		return true;
	}

	@PostMapping("/v1/")
	public ResponseEntity<Boolean> createRoomReportV1(@RequestBody RoomReport roomreport) {

		RoomReportServiceImpl.createRoomReport(roomreport);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public RoomReport findById(@PathVariable int id) throws RoomReportException {
		RoomReport roomreport = roomreportServiceImpl.findById(id);
		return roomreport;
	}

	@GetMapping("/v1/{id}")
	public ResponseEntity<RoomReport> findByIdV1(@PathVariable int id) {
		RoomReport roomreport = roomreportServiceImpl.findById(id);

		return new ResponseEntity<RoomReport>(roomreport, HttpStatus.OK);
	}

}
