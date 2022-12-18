package com.app.MyMovies.dto;

import com.app.MyMovies.entities.Category;
import com.app.MyMovies.service.MovieService;

import java.util.List;

public class ReportCategoryMovies {
    Category category;
    List<MovieService> moviesList;
}
