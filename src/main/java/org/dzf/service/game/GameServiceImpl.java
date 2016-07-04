package org.dzf.service.game;

import java.util.List;

import javax.annotation.Resource;

import org.dzf.domain.game.Game;
import org.dzf.domain.game.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "gameService")
public class GameServiceImpl implements GameService{
	@Resource(name = "gameRepository")
	private GameRepository GameRepository;

	public void saveGame(Game game) {
		GameRepository.save(game);
	}

	@Transactional(transactionManager="gameTransactionManager",rollbackFor=RuntimeException.class)
	public void saveGameList(List<Game> games) {
		int i = 0;
		for (Game game : games) {
			GameRepository.save(game);
			i++;
		}
		if(i > 3)
			throw new RuntimeException(); 
	}

}
