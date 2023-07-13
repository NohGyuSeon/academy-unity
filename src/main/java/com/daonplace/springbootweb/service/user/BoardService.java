package com.daonplace.springbootweb.service.user;

import com.daonplace.springbootweb.domain.user.board.Board;
import com.daonplace.springbootweb.repository.user.BoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    @Transactional
    public Board updateBoard(Long boardId, String title, String content) {
        Board findBoard = boardRepository.findOne(boardId);
        findBoard.setTitle(title);
        findBoard.setContent(content);
        return findBoard;
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    public Board findOne(Long boardId) {
        return boardRepository.findOne(boardId);
    }

}
