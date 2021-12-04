package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "id_question")
    private String id = UUID.randomUUID().toString();

    private String content;

    private boolean generic;


    public Question() {
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

    public boolean isGeneric() {
        return generic;
    }

    public void setGeneric(boolean generic) {
        this.generic = generic;
    }
}
