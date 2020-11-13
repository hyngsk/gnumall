package gnumall.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gnumall.common.util.CamelMap;
import gnumall.store.mapper.StoreMapper;

@Service
public class StoreService {

	private final StoreMapper storeMapper;

	public StoreService(StoreMapper storeMapper) {
		this.storeMapper = storeMapper;
	}

	public List<CamelMap> showProduct() throws Exception {
		return storeMapper.showProduct();
	}

}
