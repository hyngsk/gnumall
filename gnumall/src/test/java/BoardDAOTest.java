
import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gnumall.board.dao.BoardDAO;
import gnumall.board.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/root-context.xml" })

public class BoardDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Inject
	private BoardDAO boardDAO;

	@Test
	@Ignore
	public void testGetBoardList() throws Exception {
		List<BoardVO> boardList = boardDAO.getBoardList();
		logger.info("\n Board List \n");
		if (boardList.size() > 0) {
			for (BoardVO list : boardList) {
				logger.info(list.board_subject);
			}
		} else {
			logger.info("데이터가 없습니다.");
		}
	}

	@Test
	@Ignore
	public void testGetBoardContent() throws Exception {
		BoardVO boardVO = boardDAO.getBoardContent(1);
		logger.info("\n Board List \n");
		if (boardVO != null) {
			logger.info("글번호: " + boardVO.getBoard_seq());
			logger.info("작성자: " + boardVO.getBoard_writer());
			logger.info("글내용: " + boardVO.getBoard_content());
			logger.info("글제목: " + boardVO.getBoard_subject());
			logger.info("작성일: " + boardVO.getBoard_date());
		} else {
			logger.info("데이터가 없습니다.");
		}
	}

	@Test
	public void testInsertBoard() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_subject("첫번째 게시물 입니다.");
		boardVO.setBoard_content("첫번째 게시물입니다.");

		int result = boardDAO.insertBoard(boardVO);
		logger.info("\n Insert Board Result" + result);
		if (result == 1) {
			logger.info("\n 게시물 등록 성공");
		} else {
			logger.info("\n 게시물 등록 실패");
		}
	}

	@Test
	@Ignore
	public void testUpdateBoard() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_seq(1);
		boardVO.setBoard_subject("첫번째 게시물 입니다-수정 합니다.");
		boardVO.setBoard_content("첫번째 게시물 입니다-수정 합니다.");

		int result = boardDAO.updateBoard(boardVO);
		logger.info("\n Update Board Result \n");
		if (result > 0) {
			logger.info("\n 게시물 수정 성공");
		} else {
			logger.info("\n 게시물 수정 실패");
		}
	}

	@Test
	@Ignore
	public void testDeleteBoard() throws Exception {
		int result = boardDAO.deleteBoard(1);
		logger.info("\n Delete Board Result \n");
		if (result > 0) {
			logger.info("\n 게시물 삭제 성공");
		} else {
			logger.info("\n 게시물 삭제 실패");
		}
	}

}