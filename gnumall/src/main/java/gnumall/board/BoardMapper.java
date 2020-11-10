package gnumall.board;

import gnumall.board.model.BoardVO;
import gnumall.common.util.CamelMap;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface BoardMapper {
	List<BoardVO> getBoardList() throws SQLException;
}
