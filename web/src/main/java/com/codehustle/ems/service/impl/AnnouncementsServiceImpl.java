package com.codehustle.ems.service.impl;

import com.codehustle.ems.documents.Announcements;
import com.codehustle.ems.documents.DatabaseSequence;
import com.codehustle.ems.repository.AnnouncementsRepository;
import com.codehustle.ems.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class AnnouncementsServiceImpl implements AnnouncementsService {

    @Autowired
    private AnnouncementsRepository announcementsRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void addAnnouncement(Announcements announcements) {
        announcements.setId(generateSequence());
        announcementsRepository.save(announcements);
    }

    private long generateSequence(){
        DatabaseSequence sequence = mongoOperations.findAndModify(Query.query(where("_id").is(Announcements.seq)),
                new Update().inc("seq",1),options().returnNew(true).upsert(true),DatabaseSequence.class);
        return !Objects.isNull(sequence) ? sequence.getSeq() : 1;
    }
}
