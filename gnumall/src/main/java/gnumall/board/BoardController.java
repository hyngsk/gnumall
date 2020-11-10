package gnumall.board;


import gnumall.common.util.DataMap;
import gnumall.common.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import gnumall.board.model.BoardVO;
import gnumall.board.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

@Controller
//@RequestMapping(value="/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value = "/board", method = {RequestMethod.GET})
	public String getPostTable(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//model.addAttribute("boardList",boardService.getBoardList());
		DataMap paramMap = HttpUtil.getRequestDataMap(request);
		logger.info("Hello Board");
		logger.info("session ID : " + request.getRequestedSessionId());
		logger.info("{}",paramMap);
		//logger.info("request : "+ request + "response : "+ response);
		
		try {
			logger.info("getBoardList 쿼리 실행 결과: " + boardService.getBoardList());
		} catch(Exception e) {
			logger.error("게시물 조회 오류 : {}",e);
		}
		
		return "/content/board";
	}

}
