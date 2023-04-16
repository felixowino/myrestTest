package com.example.demo.RepoPackg;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entitypackage.LyrcsEntity;

@Repository
public interface JpaRepoClass extends JpaRepository<LyrcsEntity, Integer >{

	List<LyrcsEntity> findByMysongNameOrMyArtist(String title, String name);

}
