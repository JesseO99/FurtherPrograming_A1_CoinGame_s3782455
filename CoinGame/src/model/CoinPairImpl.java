/**
 * 
 */
package model;

import model.interfaces.Coin;
import model.interfaces.CoinPair;

/**
 * @author jeje1
 *
 */
public class CoinPairImpl implements CoinPair 
{
	private Coin coin1,coin2;
	public CoinPairImpl(Coin coin1, Coin coin2)
	{
		this.coin1 = coin1;
		this.coin2 = coin2;
	}
	@Override
	public Coin getCoin1() //returnsCoin1
	{
		return coin1;
	}

	@Override
	public Coin getCoin2() //returns coin 1
	{
		return coin2;
	}

	@Override
	public boolean equals(CoinPair coinPair) //Compares coin faces to see if they match and returns true or false
	{
		if((this.coin1.equals((coinPair.getCoin1())) && (this.coin2.equals(coinPair.getCoin2()))))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean equals(Object coinPair)//Checks to see if object is a coinPair and then checks coin faces.
	{
		if(coinPair instanceof CoinPair)
		{
			return equals(coinPair);
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public String toString()
	{
		return coin1.toString() + ", " + coin2.toString();
	}
	
	@Override
	public int hashCode()
	{
		return 0;//TODO
	}

}
