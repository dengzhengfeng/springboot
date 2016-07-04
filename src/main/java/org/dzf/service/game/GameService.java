package org.dzf.service.game;

import java.util.List;

import org.dzf.domain.game.Game;

public interface GameService {
	public void saveGame(Game game);
	public void saveGameList(List<Game> games);
}
