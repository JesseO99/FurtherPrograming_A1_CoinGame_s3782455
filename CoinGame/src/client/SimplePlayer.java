package client;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SimplePlayer implements Player {

	public SimplePlayer(String string, String string2, int i) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPlayerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayerName(String playerName) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPoints(int points) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPlayerId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setBet(int bet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getBet() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBetType(BetType betType) {
		// TODO Auto-generated method stub

	}

	@Override
	public BetType getBetType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetBet() {
		// TODO Auto-generated method stub

	}

	@Override
	public CoinPair getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResult(CoinPair coinPair) {
		// TODO Auto-generated method stub

	}

}
