package gnumall.store;

import gnumall.common.util.CamelMap;
import gnumall.common.util.DataMap;
import gnumall.common.util.HttpUtil;
import gnumall.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;


@Controller
public class StoreController {
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

	private final StoreService storeService;

	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}


	/*
	상품 갯수(페이징 처리에 필요),
	정보(실제로 보여주는 부분)
	를 가져와 뷰로 전달하는 메소드
	 */
	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public String getProduct(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		DataMap paramMap = HttpUtil.getRequestDataMap(request);
		logger.info("Hello Store");
		logger.info("session ID : " + request.getRequestedSessionId());
		logger.info("{}", paramMap);
		logger.info("{}", paramMap);

		List<CamelMap> resultList = new ArrayList<CamelMap>();
		
		
		
		// 상품 갯수 가져오기

		// 상품정보 받아오기
		try {
			resultList = storeService.showProduct();
			logger.info("showProduct 쿼리 실행 결과 : ");
			resultList.forEach((temp)->{
				logger.info("{}", temp);
			});
		} catch (Exception e) {
			logger.error("게시물 조회 오류 : {}", e);
		}

		model.addAttribute("list", resultList);
		return "/content/store";
	}
}
