package com.ziumks.board;

import com.ziumks.board.domain.BoardDTO;
import com.ziumks.board.service.BoardService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testOfRegisterBoard() {
        BoardDTO params = new BoardDTO();
        params.setTitle("Service Test Title");
        params.setContent("registerBoard를 테스트 합니다.");
        params.setWriter("이용하");

        boolean result = boardService.registerBoard(params);
        System.out.println("[registerTest] Result is :" + result);
    }
}
