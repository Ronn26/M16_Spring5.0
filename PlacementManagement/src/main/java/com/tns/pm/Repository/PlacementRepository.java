package com.tns.pm.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.pm.entities.Placement;

public interface PlacementRepository extends JpaRepository<Placement, Integer> {

	public List<Placement> findByCollegeId(Integer collegeId);
}
