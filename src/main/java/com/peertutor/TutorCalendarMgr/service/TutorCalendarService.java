package com.peertutor.TutorCalendarMgr.service;

import com.peertutor.TutorCalendarMgr.repository.TutorCalendarRepository;
import com.peertutor.TutorCalendarMgr.service.dto.TutorCalendarMgrDTO;
import com.peertutor.TutorCalendarMgr.service.mapper.TutorCalendarMapper;
import com.peertutor.TutorCalendarMgr.model.TutorCalendar;
import com.peertutor.TutorCalendarMgr.model.viewmodel.request.TutorCalendarReq;


@Service
public abstract class TutorCalendarService implements TutorCalendarRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(TutorCalendarService.class);
    private final TutorCalendarMapper tutorCalendarMapper;
    private TutorCalendarRepository tutorCalendarRepository;
    
    public TutorCalendarMgrDTO addAvailableDatetime(TutorCalendarReq req) {
    	TutorCalendar tutorCalendar = tutorCalendarRepository.findById(req.id);
    	if(tutorCalendar == null) {
    		tutorCalendar = new TutorCalendar();
    	}

    	tutorCalendar.setTutorID(req.tutorID);
    	tutorCalendar.setAvailableDate(req.availableDate);
    	tutorCalendar.setStartTime(req.startTime);
    	tutorCalendar.setEndTime(req.endTime);
    	
    	try {
    		tutorCalendar = tutorCalendarRepository.save(tutorCalendar);
        } catch (Exception e) {
            logger.error("Add available time slot fail: " + e.getMessage());
            return null;
        }

    	TutorCalendarMgrDTO  result = tutorCalendarMapper.toDto(tutorCalendar);
        return result;
    }
    public TutorCalendarMgrDTO getTutorCalendar(Long tutorID) {
    	TutorCalendar tutorCalendar = tutorCalendarRepository.findByTutorId(tutorID);

    	if (tutorCalendar == null) {
            return null;
        }

    	TutorCalendarMgrDTO  result = tutorCalendarMapper.toDto(tutorCalendar);
        return result;
    }
    
//    public TutorCalendarMgrDTO updateAvailableDatetime(TutorCalendarMgrDTO tutorCalendarMgrDTO) {
//    	TutorCalendar tutorCalendarMgr = tutorCalendarRepository.findById(tutorCalendarMgrDTO.getId());
//    	if(tutorCalendarMgr == null) {
//    		return null;
//    	}
//    	tutorCalendarMgr.setAvailableDate(tutorCalendarMgrDTO.getAvailableDate());
//    	tutorCalendarMgr.setStartTime(tutorCalendarMgrDTO.getStartTime());
//    	tutorCalendarMgr.setEndTime(tutorCalendarMgrDTO.getEndTime());
//    	
//    	try {
//    		tutorCalendarMgr = tutorCalendarRepository.save(tutorCalendarMgr);
//        } catch (Exception e) {
//            logger.error("Add available time slot fail: " + e.getMessage());
//            return null;
//        }
//
//    	TutorCalendarMgrDTO  result = tutorCalendarMapper.toDto(tutorCalendarMgr);
//        return result;
//    }
    
}
