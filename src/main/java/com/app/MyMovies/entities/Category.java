package com.app.MyMovies.entities;


import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("category")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    private Integer ageMinimum;

    
    
    
    
    
}
