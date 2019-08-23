package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Coin;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine 
{
	private Collection<GameEngineCallback> gameEngineCallbacks = new ArrayList<GameEngineCallback>();
	private Collection<Player> players = new HashSet<Player>();
	
	@Override
	public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2) throws IllegalArgumentException
	{	 
		spinnerArgumentCheck(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);
		CoinImpl coin1 = new CoinImpl(1);
		CoinImpl coin2 = new CoinImpl(2);
		CoinPair coinPair = new CoinPairImpl(coin1, coin2);
		flipCoin(initialDelay1, finalDelay1, delayIncrement1, coinPair,player);
		for(GameEngineCallback gameEngineCallback: gameEngineCallbacks)
		{
			gameEngineCallback.playerResult(player, coinPair, this);
		}
		player.setResult(coinPair);
	}

	@Override
	public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) throws IllegalArgumentException 
	{
		spinnerArgumentCheck(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);
		CoinImpl coin1 = new CoinImpl(1);
		CoinImpl coin2 = new CoinImpl(2);
		CoinPair coinPair = new CoinPairImpl(coin1, coin2);
		flipCoin(initialDelay1, finalDelay1, delayIncrement1, coinPair,null);
		applyBetResults(coinPair);
		for(GameEngineCallback gameEngineCallback: gameEngineCallbacks)
		{
			gameEngineCallback.spinnerResult( coinPair, this);
		}
	}
	private void spinnerArgumentCheck(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) throws IllegalArgumentException
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

	}
	
	private void flipCoin(int delay, int finalDelay, int delayIncrement, CoinPair coinPair,Player player)
	{
		try
		{
			if(delay <= finalDelay)
			{
				Thread.sleep(delay);
				coinPair.getCoin1().flip();
				for(GameEngineCallback gameEngineCallback: gameEngineCallbacks)
				{
					if(player != null)
					{
						gameEngineCallback.playerCoinUpdate(player, coinPair.getCoin1(), this);
					}
					else
					{
						gameEngineCallback.spinnerCoinUpdate(coinPair.getCoin1(), this);
					}
				}
				coinPair.getCoin2().flip();
				for(GameEngineCallback gameEngineCallback: gameEngineCallbacks)
				{
					if(player != null)
					{
						gameEngineCallback.playerCoinUpdate(player, coinPair.getCoin2(), this);
					}
					else
					{
						gameEngineCallback.spinnerCoinUpdate(coinPair.getCoin2(), this);
					}
				}
				delay += delayIncrement;
				flipCoin(delay, finalDelay, delayIncrement, coinPair, player);
			}
		}
		catch(InterruptedException e)
		{
			throw new IllegalArgumentException();
		}

	}

	@Override
	public void applyBetResults(CoinPair spinnerResult) 
	{
		for(Player player: players)
		{
			System.out.println(player.getPlayerName());
			player.getBetType().applyWinLoss(player, spinnerResult);
		}
 
	}

	@Override
	public void addPlayer(Player player) //Checks to see if player already exists. If it doesn't exist it adds a new player
	{
		if(getPlayer(player.getPlayerId()) != null)
		{
			players.remove(getPlayer(player.getPlayerId()));
		}
		players.add(player);
	}

	@Override
	public Player getPlayer(String id) //Returns player with the same player ID
	{
		for(Player player: players)
		{
			if(player.getPlayerId().matches(id))
			{
				return player;
			}
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) //Removes player from players hash set
	{
		return players.remove(player);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) //Adds a game engine callback
	{
		gameEngineCallbacks.add(gameEngineCallback);	
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) //Removes a game engine callback
	{
		return gameEngineCallbacks.remove(gameEngineCallback);
	}

	@Override
	public Collection<Player> getAllPlayers() //returns unmodifiable collection of players
	{
		return Collections.unmodifiableCollection(players);
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) //Places the players bet
	{
		if(player.setBet(bet)&& betType != BetType.NO_BET)
		{
			player.setBetType(betType);
			return true;
		}
		return false;
	}
}
