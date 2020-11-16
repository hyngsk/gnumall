package gnumall.board.service;

import java.util.List;
import java.util.Map;

import gnumall.board.model.BoardVO;

public interface BoardService {
	public List<BoardVO> getBoardList() throws Exception;
}
