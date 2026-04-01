package com.gustavo.ecologistics.repository;

import com.gustavo.ecologistics.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

}
