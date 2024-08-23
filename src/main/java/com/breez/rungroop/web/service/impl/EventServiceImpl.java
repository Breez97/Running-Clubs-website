package com.breez.rungroop.web.service.impl;

import com.breez.rungroop.web.dto.EventDTO;
import com.breez.rungroop.web.model.Club;
import com.breez.rungroop.web.model.Event;
import com.breez.rungroop.web.repository.ClubRepository;
import com.breez.rungroop.web.repository.EventRepository;
import com.breez.rungroop.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

	private EventRepository eventRepository;
	private ClubRepository clubRepository;

	@Autowired
	public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
		this.eventRepository = eventRepository;
		this.clubRepository = clubRepository;
	}

	@Override
	public void createEvent(Long clubId, EventDTO eventDTO) {
		Club club = clubRepository.findById(clubId).get();
		Event event = mapToEvent(eventDTO);
		event.setClub(club);
		eventRepository.save(event);
	}

	private Event mapToEvent(EventDTO eventDTO) {
		return Event.builder()
				.id(eventDTO.getId())
				.title(eventDTO.getTitle())
				.startTime(eventDTO.getStartTime())
				.endTime(eventDTO.getEndTime())
				.type(eventDTO.getType())
				.photoUrl(eventDTO.getPhotoUrl())
				.createdOn(eventDTO.getCreatedOn())
				.updatedOn(eventDTO.getUpdatedOn())
				.build();
	}

}
