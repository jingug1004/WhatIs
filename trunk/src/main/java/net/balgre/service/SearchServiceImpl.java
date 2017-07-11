package net.balgre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.balgre.domain.Product;
import net.balgre.network.SearchRetroImpl;

@Service
public class SearchServiceImpl implements SearchService{
	
	/*search*/
	@Override
	public List<Product> search2(String search) {
		// TODO Auto-generated method stub
		
		SearchRetroImpl SRI = new SearchRetroImpl();
		
		List<Product> res = SRI.search(search);
		
		return res;
	}

}
