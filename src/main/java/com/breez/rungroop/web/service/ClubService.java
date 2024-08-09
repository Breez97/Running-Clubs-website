package com.breez.rungroop.web.service;

import com.breez.rungroop.web.dto.ClubDTO;
import com.breez.rungroop.web.model.Club;

import java.util.List;

public interface ClubService {

	List<ClubDTO> findAllClubs();
	Club saveClub(ClubDTO club);

	ClubDTO findClubById(long clubId);

	void updateClub(ClubDTO club);
}
