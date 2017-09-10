package br.com.fiap.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.dao.AnimeDAO;
import br.com.fiap.entity.anime.Anime;

@Repository
public class AnimeDAOImpl extends GenericDAOImpl<Anime, Integer> implements AnimeDAO {

}
