package model.util;

import model.CoinImpl;
import model.enumeration.CoinFace;
import model.interfaces.Coin;

public class GeUtil 
{
	public static String coinFaceToString(Coin coin)
	{
		switch(coin.getFace())
		{
			case HEADS:
				return "Heads";

			case TAILS:
				return "Tails";
			
		}
		return null;
	}
}
