package gnumall.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import gnumall.board.dao.BoardDAO;
import gnumall.board.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;

	
	public List<BoardVO> getBoardList() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList();
	}

}

