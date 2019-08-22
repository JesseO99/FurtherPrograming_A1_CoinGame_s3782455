package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SimplePlayer implements Player 
{

	private String playerId;
	private String playerName;
	private int points;
	private int bet;
	private BetType betType;
	private CoinPair coinPair;
	public SimplePlayer(String playerId, String playerName, int initialPoints) 
	{
		this.playerId = playerId;		//Sets player ID
		this.playerName = playerName;	//Sets player Name
		points = initialPoints;			//Sets points
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public String getPlayerName() //Returns Player name
	{
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) //Changes player name
	{
		this.playerName = playerName;

	}

	@Override
	public int getPoints() //Returns players current points
	{
		// TODO Auto-generated method stub
		return points;
	}

	@Override
	public void setPoints(int points) //Sets points to specified points.
	{
		this.points = points;
	}

	@Override
	public String getPlayerId() //Returns PlayerId
	{
		// TODO Auto-generated method stub
		return playerId;
	}

	@Override
	public boolean setBet(int bet) //If it is a valid bet, bet is set and returns true.
	{	
		if(bet > 0 && points > bet)
		{
			this.bet = bet;
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getBet() //Returns bet
	{
		// TODO Auto-generated method stub
		return bet;
	}
	
	@Override
	public void setBetType(BetType betType) //Sets BetType
	{
		this.betType = betType;
		

	}

	@Override
	public BetType getBetType() //Returns betType
	{
		// TODO Auto-generated method stub
		return betType;
	}

	@Override
	public void resetBet() //Sets bet = 0 and betType to no bet
	{
		bet = 0;
		betType = BetType.NO_BET;
		// TODO Auto-generated method stub
		//Code Still needs to set betType to NO_BET
	}

	@Override
	public CoinPair getResult() 
	{
		// TODO Auto-generated method stub
		return coinPair;
	}

	@Override
	public void setResult(CoinPair coinPair) 
	{
		this.coinPair = coinPair;

	}

}
