package com.breez.rungroop.web.service;

import com.breez.rungroop.web.dto.EventDTO;

public interface EventService {

	void createEvent(Long clubId, EventDTO eventDTO);

}
