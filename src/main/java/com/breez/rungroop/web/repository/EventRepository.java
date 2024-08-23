package com.breez.rungroop.web.repository;

import com.breez.rungroop.web.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {



}
