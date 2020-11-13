package gnumall.store.mapper;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import gnumall.common.util.CamelMap;

@Repository
public interface StoreMapper {
	List<CamelMap> showProduct() throws SQLException;

}
