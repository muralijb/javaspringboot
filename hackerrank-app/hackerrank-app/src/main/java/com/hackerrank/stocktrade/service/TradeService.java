package com.hackerrank.stocktrade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hackerrank.stocktrade.Trade;
import com.hackerrank.stocktrade.User;
import com.hackerrank.stocktrade.repository.TradeRepository;
import com.hackerrank.stocktrade.repository.UserRepository;

@Service
public class TradeService {

	
	@Autowired
    TradeRepository repository;
     @Autowired

     UserRepository userrepository;
    public List<Trade> getAllTrades()
    {
        List<Product> tradeList = repository.findAll();
         
        if(tradeList.size() > 0) {
            return tradeList;
        } else {
            return new ArrayList<Trade>();
        }
    }
     
    public Trade getTradeById(Long id) 
    {
    	return repository.findById(id).get();
    	
    }
     
    public Product create(Trade entity) 
    {
      
       Trade trd = repository.save(entity);
             
            return trd;
       
        }

	public void deleteTrade(Long id) {
		
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	public String updateTrade(Trade trd,Long id) {
		 
		Optional<Product> trade = repository.findById(id);
		String str=null;
		if(trade.isPresent()) {

                 Long id, String type, User user, String symbol, Integer quantity, Float price, Timestamp timestamp

			trade.get().setUser(trd.getUser());
			trade.get().setSymbol(trd.getSymbol());
			trade.get().setQuantity(trd.getQuantity());
			trade.get().set.Price(trd.getPrice());
			trade.get().setTime(trd.getTime());
			
		 repository.save(trd);
		 str="Updated successfully";
		}else
		{
			trade=null;
			str="Record not found";
		}
	 return str; 
    }
    
}
  
