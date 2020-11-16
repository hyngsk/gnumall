package gnumall.board.dao;

import java.util.List;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import gnumall.board.model.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	

	@Override 
	public List<BoardVO> getBoardList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gnumall.board.BoardMapper.getBoardList");
	}

	@Override
	public BoardVO getBoardContent(int board_seq) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("gnumall.board.BoardMapper.getBoardContent",board_seq);
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("gnumall.board.BoardMapper.insertBoard",boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("gnumall.board.BoardMapper.updateBoard",boardVO);
	}

	@Override
	public int deleteBoard(int board_seq) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("gnumall.board.BoardMapper.deleteBoard",board_seq);
	}

}

