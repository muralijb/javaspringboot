package com.hackerrank.stocktrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.trade;

import com.hackerrank.stocktrade.StockTradeService;

@RestController
@RequestMapping(value = "/products")
public class StockBokerController {
	@Autowired
	StockTradeService service;
	
	@PostMapping("/save")
    public ResponseEntity<String> createOrUpdateStock(@RequestBody Trade entity) {
		   service.create(entity);
           return new ResponseEntity<String>("Stock trade Share saved", HttpStatus.CREATED); 
        }
	
	@GetMapping(value="/getStockTade/{id}")
	public Stock getTadeById(@PathVariable Long id) {
		
		return service.getTradeById(id);
		
	}
	@GetMapping(value="/getAllStockTradess/")
	public List<Stock> getAllTrades() {
		
		return service.getAllTrades();
		
	}
	
	@DeleteMapping("/Stockdelete/{Id}")
	 public ResponseEntity<String> deleteTrade(@PathVariable(name="Id")Long Id){
	  service.deleteTrade(Id);
	  System.out.println("Stock Deleted Successfully");
	return new ResponseEntity<String>("Deleted",HttpStatus.GONE);
	  
	 }
	
	@PutMapping("/Stockupdate/{id}")
	 public ResponseEntity<String> updateTrade(@RequestBody Trade trade,@PathVariable(name="id")Long id){
		
		String str = service.updateTrade(trade,id);
		
	   return new ResponseEntity<String>(str,HttpStatus.OK);
	 }
	
}

