package com.codehustle.ems.repository;

import com.codehustle.ems.documents.Announcements;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementsRepository extends MongoRepository<Announcements,Long> {
}
