package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @Column(name = "id_answer")
    private String id = UUID.randomUUID().toString();

    private String content;

    public Answer() {
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
