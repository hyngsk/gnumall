package gnumall.board.dao;

import java.util.List;
import gnumall.board.model.BoardVO;

public interface BoardDAO {
	public List<BoardVO> getBoardList() throws Exception;
	public BoardVO getBoardContent(int board_seq) throws Exception;
	public int insertBoard(BoardVO boardVO) throws Exception;
	public int updateBoard(BoardVO boardVO) throws Exception;
	public int deleteBoard(int board_seq) throws Exception;

}