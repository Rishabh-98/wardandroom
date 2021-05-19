
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

import com.wardandroom.entities.WardReport;
import com.wardandroom.exception.WardReportException;
import com.wardandroom.service.WardReportServiceImpl;

@RestController

@RequestMapping("/api/wardreport/")
public class WardReportController {

	@Autowired
	private WardReportServiceImpl wardreportServiceImpl;

	@PostMapping("/")
	public boolean createWardReport(@RequestBody WardReport wardreport) {

		wardreportServiceImpl.createWardReport(wardreport);
		return true;
	}

	@PostMapping("/v1/")
	public ResponseEntity<Boolean> createWardReportV1(@RequestBody WardReport wardreport) {

		wardreportServiceImpl.createWardReport(wardreport);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public WardReport findById(@PathVariable int id) throws WardReportException {
		WardReport wardreport = wardreportServiceImpl.findById(id);
		return wardreport;
	}

	@GetMapping("/v1/{id}")
	public ResponseEntity<WardReport> findByIdV1(@PathVariable int id) {
		WardReport wardreport = wardreportServiceImpl.findById(id);

		return new ResponseEntity<WardReport>(wardreport, HttpStatus.OK);
	}

}
