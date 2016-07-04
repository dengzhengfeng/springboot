package org.dzf.domain.game;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository(value="gameRepository")
public interface GameRepository extends JpaRepository<Game,UUID>{
}
