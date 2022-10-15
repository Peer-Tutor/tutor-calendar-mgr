package com.peertutor.TutorCalendarMgr.service.mapper;

import com.peertutor.TutorCalendarMgr.model.TutorCalendar;
import com.peertutor.TutorCalendarMgr.service.dto.TutorCalendarMgrDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TutorCalendarMapper extends EntityMapper<TutorCalendarMgrDTO, TutorCalendar>{
	TutorCalendar toEntity(TutorCalendarMgrDTO tutorCalendarMgrDTO);

	TutorCalendarMgrDTO toDto(TutorCalendar tutorCalendar);

    default TutorCalendar fromId(Long id) {
        if (id == null) {
            return null;
        }
        TutorCalendar tutorCalendar = new TutorCalendar();
        tutorCalendar.setId(id);
        return tutorCalendar;
    }
}
