package com.codehustle.ems.documents;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "database_sequence")
@Data
public class DatabaseSequence {

    @Id
    private String id;

    private long seq;

}
