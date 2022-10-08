package com.codehustle.ems.controller;

import com.codehustle.ems.documents.Announcements;
import com.codehustle.ems.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementsService announcementsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnnouncement(@RequestBody Announcements announcements){
        announcementsService.addAnnouncement(announcements);
    }
}
