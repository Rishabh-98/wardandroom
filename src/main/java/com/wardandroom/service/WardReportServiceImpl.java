
package com.wardandroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wardandroom.exception.WardReportException;
import com.wardandroom.repository.WardReportRepository;
import com.wardandroom.service.IWardReportService;
import com.wardandroom.entities.WardReport;

@Service
public class WardReportServiceImpl implements IWardReportService {

	@Autowired
	private WardReportRepository wardreportRepository;

	@Override
	public boolean createWardReport(WardReport wardreport) {

		wardreportRepository.save(wardreport);

		return false;
	}

	@Override 
	public boolean updateWardReport(WardReport wardreport){ 
		// TODOAuto-generated method stub 
		return false; 
		}

	@Override
	public WardReport findById(int id) {
		if (!wardreportRepository.existsById(id)) {
			throw new WardReportException("Ward Not Found");
		}

		WardReport e = wardreportRepository.findById(id).get();
		return e;
	}

}
