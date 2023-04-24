package com.example.demo.RepoPackg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entitypackage.MembersEntity;
@Repository
public interface Urepo extends JpaRepository<MembersEntity, Integer> {

	MembersEntity findByUsername(String string);

}
