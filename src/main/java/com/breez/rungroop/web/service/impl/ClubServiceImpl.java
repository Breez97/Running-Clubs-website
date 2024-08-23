package com.breez.rungroop.web.service.impl;

import com.breez.rungroop.web.dto.ClubDTO;
import com.breez.rungroop.web.model.Club;
import com.breez.rungroop.web.repository.ClubRepository;
import com.breez.rungroop.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

	private ClubRepository clubRepository;

	@Autowired
	public ClubServiceImpl(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

	@Override
	public List<ClubDTO> findAllClubs() {
		List<Club> clubs = clubRepository.findAll();
		return clubs.stream().map(this::mapToClubDTO).collect(Collectors.toList());
	}

	@Override
	public Club saveClub(ClubDTO clubDTO) {
		Club club = mapToClub(clubDTO);
		return clubRepository.save(club);
	}

	@Override
	public ClubDTO findClubById(long clubId) {
		Club club = clubRepository.findById(clubId).get();
		return mapToClubDTO(club);
	}

	@Override
	public void updateClub(ClubDTO clubDto) {
		Club club = mapToClub(clubDto);
		clubRepository.save(club);
	}

	@Override
	public void delete(Long clubId) {
		clubRepository.deleteById(clubId);
	}

	@Override
	public List<ClubDTO> searchClubs(String query) {
		List<Club> clubs = clubRepository.searchClubs(query);
		return clubs.stream().map(club -> mapToClubDTO(club)).collect(Collectors.toList());
	}

	private Club mapToClub(ClubDTO club) {
		return Club.builder()
				.id(club.getId())
				.title(club.getTitle())
				.photoUrl(club.getPhotoUrl())
				.content(club.getContent())
				.createdOn(club.getCreatedOn())
				.updatedOn(club.getUpdatedOn())
				.build();
	}

	private ClubDTO mapToClubDTO(Club club) {
		return ClubDTO.builder()
				.id(club.getId())
				.title(club.getTitle())
				.content(club.getContent())
				.photoUrl(club.getPhotoUrl())
				.createdOn(club.getCreatedOn())
				.updatedOn(club.getUpdatedOn())
				.build();
	}

}
