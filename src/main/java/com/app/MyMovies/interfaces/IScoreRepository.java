/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.MyMovies.interfaces;

import com.app.MyMovies.entities.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Andres
 */
public interface IScoreRepository extends MongoRepository<Score, String> {
    
}
