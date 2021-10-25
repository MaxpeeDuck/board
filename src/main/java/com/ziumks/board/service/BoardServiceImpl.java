package com.ziumks.board.service;

import com.ziumks.board.domain.BoardDTO;
import com.ziumks.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public boolean registerBoard(BoardDTO pararms) {
        int queryResult = 0;

        if(pararms.getIdx() == null) {
            queryResult = boardMapper.insertBoard(pararms);
        } else {
            queryResult = boardMapper.updateBoard(pararms);
        }
        return (queryResult == 1) ? true : false;
    }

    @Override
    public BoardDTO getBoardDetail(Long idx) {
        return boardMapper.selectBoardDetail(idx);
    }

    @Override
    public boolean deleteBoard(long idx) {
        int queryResult = 0;

        BoardDTO board = boardMapper.selectBoardDetail(idx);
        if(board != null && "N".equals(board.getDeleteYn())) {
            queryResult = boardMapper.deleteBoard(idx);
        }
        return queryResult == 1 ? true : false;
    }

    @Override
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> boardList = Collections.emptyList();

        int boardTotalcount = boardMapper.selectBoardTotalCount();

        if(boardTotalcount > 0) {
            boardList = boardMapper.selectBoardList();
        }

        return boardList;
    }
}
