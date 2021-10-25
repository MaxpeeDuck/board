package com.ziumks.board.service;

import com.ziumks.board.domain.BoardDTO;

import java.util.List;

public interface BoardService {
    public boolean registerBoard(BoardDTO pararms);

    public BoardDTO getBoardDetail(Long idx);

    public boolean deleteBoard(long idx);

    public List<BoardDTO> getBoardList();
}
