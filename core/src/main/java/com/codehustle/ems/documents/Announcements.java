package com.codehustle.ems.documents;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;

@Document(collection = "announcements")
@Data
public class Announcements {

    @Transient
    public static final String seq = "announcements_seq";

    @Id
    private Long id;

    private String message;
    private Long userId;
}
