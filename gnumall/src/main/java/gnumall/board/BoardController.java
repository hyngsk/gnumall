package gnumall.board;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import gnumall.board.BoardController;
import gnumall.board.service.BoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import gnumall.board.BoardMapper;
import gnumall.board.model.BoardVO;
import gnumall.board.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

@Controller
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardMapper mapper;

    @Inject
    public BoardController(BoardMapper mapper) {
        this.mapper = mapper;
    }

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String getBoardList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        logger.info("getBoardList...");
        
        List<BoardVO> boardList = mapper.getBoardList();
        try {
			boardList = mapper.getBoardList();
			logger.info("getBoardList 쿼리 실행 결과 : ");
			boardList.forEach((temp) -> {
				logger.info("{}", temp);
			});
		} catch (Exception e) {
			logger.error("게시물 조회 오류 : {}", e);
		}
        model.addAttribute("list",boardList);
        
		
        return "/content/board";
    }
}
