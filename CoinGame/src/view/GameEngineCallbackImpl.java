package view;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.util.GeUtil;
import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
   private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

   public GameEngineCallbackImpl()
   {
      // NOTE need to also set the console to FINE in %JRE_HOME%\lib\logging.properties
      logger.setLevel(Level.FINE);
   }

   public void playerCoinUpdate(Player player, Coin coin, GameEngine engine)
   {
      // intermediate results logged at Level.FINE
      logger.log(Level.FINE, String.format("%s coin %s flipped to %s", player.getPlayerName(), coin.getNumber(), GeUtil.coinFaceToString(coin)));
      // TODO: complete this method to log intermediate results
   }

   public void playerResult(Player player, CoinPair coinPair, GameEngine engine)
   {
      // final results logged at Level.INFO
      logger.log(Level.INFO, String.format("%s, final result=Coin 1: %s, Coin 2: %s", player.getPlayerName(), GeUtil.coinFaceToString(coinPair.getCoin1()), GeUtil.coinFaceToString(coinPair.getCoin2())));
      // TODO: complete this method to log results
   }

   @Override
   public void spinnerCoinUpdate(Coin coin, GameEngine engine) 
   {
	   // TODO Auto-generated method stub
	   logger.log(Level.FINE, String.format("Spinner coin %s flipped to %s", coin.getNumber(), GeUtil.coinFaceToString(coin)));
   }

   @Override
   public void spinnerResult(CoinPair coinPair, GameEngine engine) 
   {
	   logger.log(Level.INFO, String.format("Spinner, final result = Coin 1: %s, Coin 2: %s", GeUtil.coinFaceToString(coinPair.getCoin1()),GeUtil.coinFaceToString(coinPair.getCoin2())));
	  StringBuilder finalPlayerResults = new StringBuilder("Final Player results\n");
	  for(Player player:engine.getAllPlayers())
	  {
		  finalPlayerResults.append(player.toString());
	  }
	   logger.log(Level.INFO, finalPlayerResults.toString());
   }

   // TODO: implement rest of interface
}
