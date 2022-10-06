package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.sample.command.SampleVO;
import org.zerock.sample.command.Ticket;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	// 단순문자열 반환
	@GetMapping(value="/getText", produces = "text/plain;charset=UTF-8")
	public String getText() {
		System.out.println("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		
		return "<h1>안녕하세요<h1>";
	}
	
	// 객체의 반환
	// 객체의 반환은 XML 또는 JSON을 이용.
	@GetMapping(value = "/getSample", 
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	// 컬렉션 타입의 객체 반환
	@GetMapping(value="/getList")
	public List<SampleVO> getList() {
		
//		List<SampleVO> list = new ArrayList<>();
//		
//		for(int i=1; i<=10; i++) {
//			SampleVO vo = new SampleVO(i, i+"First", i + "Last");
//			list.add(vo);
//		}
//		
//		return list;
		
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i+"First", i+"Last")).collect(Collectors.toList());
		
	}
	
	// 맵을 사용하는 경우
	@GetMapping(value="/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<>();
		
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		map.put("Second", new SampleVO(112, "스타", "로드"));
		
		return map;
	}
	
	// ResponseEntity
	@GetMapping(value="/check", params = {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	// PathVariable
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") String pid) {
		
		return new String[] {"category : " + cat, "productID" + pid};
	}
	
	// RequestBody를 이용한 방법
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		
		System.out.println("convert... ticket " + ticket);
		
		return ticket;
		// 1. JUnit 테스트로 확인 2. JSON테스트 API툴을 사용
	}	

//	@RequestMapping("/jquery01")
//	public String jquery01() {
//		return "sample/jquery01";
//	}
//	
//	@RequestMapping("/jquery02")
//	public void jquery02() {
//	}
			
}
