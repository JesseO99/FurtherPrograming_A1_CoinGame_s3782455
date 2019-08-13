package client;

import java.util.Collection;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine 
{

	@Override
	public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2) throws IllegalArgumentException 
	{	
		if(initialDelay1 < 0 || initialDelay2 < 0 || finalDelay1 < 0 || finalDelay2 < 0 || delayIncrement1 < 0 || delayIncrement2 < 0)
		{
			throw new IllegalArgumentException("Delay parameters must be greater than 0");
		}
		if(finalDelay1 < initialDelay1 || finalDelay2 < initialDelay2)
		{
			throw new IllegalArgumentException("Final delay must be greater than initial Delay");
		}
		if(delayIncrement1 > (finalDelay1 - initialDelay1) || delayIncrement2 > (finalDelay2 - initialDelay2))
		{
			throw new IllegalArgumentException("delay increment must be less than the difference between initial delay and final delay");
		}
		// TODO Auto-generated method stub
		//Requires method implementation for method. Only exception handling occurs atm.
	}

	@Override
	public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	@Override
	public void applyBetResults(CoinPair spinnerResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public Player getPlayer(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) {
		// TODO Auto-generated method stub
		return false;
	}

}
