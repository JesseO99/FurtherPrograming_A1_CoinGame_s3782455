/**
 * 
 */
package model;

import model.enumeration.CoinFace;
import model.interfaces.Coin;
import java.lang.Math;

/**
 * @author Jesse Osrecak
 *
 */
public class CoinImpl implements Coin 
{
	private CoinFace coinFace;
	private int coinNumber;
	public CoinImpl(int coinNumber)
	{
		if(Math.random() > 0.5)
		{
			coinFace = coinFace.HEADS;
		}
		else
		{
			coinFace = coinFace.TAILS;
		}
		this.coinNumber = coinNumber;
	}
	@Override
	public int getNumber() //Returns Coin Number
	{
		return coinNumber;
	}

	@Override
	public CoinFace getFace() //Returns visible coinFace
	{
		// TODO Auto-generated method stub
		return coinFace;
	}

	@Override
	public void flip() //Flips CoinFace
	{
		switch(coinFace)
		{
			case HEADS:
				coinFace = CoinFace.TAILS;
				break;
			case TAILS:
				coinFace = CoinFace.HEADS;
				break;
		}
		// TODO Auto-generated method stub

	}

	@Override
	public boolean equals(Coin coin) //Compares Coins to see if they show the same face and returns true or false.
	{
		return coin.getFace() == coinFace;
	}
	
	@Override
	public boolean equals(Object coin)//Checks to see if object is coin before cheking objects face.
	{
		if(coin instanceof Coin)
		{
			return equals(coin);
		}
		else
		{
			return false;
		}
	}
	
	@Override 
	public int hashCode()
	{
		//TODO no method implementation
		return coinFace.hashCode();
	}
	
	@Override
	public String toString()
	{
		String cf = "NoFace";
		switch(coinFace)
		{
		case HEADS:
			cf = "Heads";
			break;
		case TAILS:
			cf = "Tails";
			break;
		}
		return "coin " + coinNumber +":	"+ cf;
	}

}
