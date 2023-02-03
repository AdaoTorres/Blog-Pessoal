package org.generation.blogpessoal.blogpessoal.repository;

import java.util.List;

import org.generation.blogpessoal.blogpessoal.model.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {

	public List<PostagemModel> findAllByDescricaoContainingIgnoreCase(@Param("titulo") String titulo);

}
