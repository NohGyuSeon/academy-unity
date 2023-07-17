package com.daonplace.springbootweb.service.user;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.board.Board;
import com.daonplace.springbootweb.dto.user.BoardDto;
import com.daonplace.springbootweb.handler.ex.CustomApiException;
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

    /**
     * 게시글 작성
     */
    @Transactional
    public Long createBoard(BoardDto boardDto, User user) {
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        board.setBoardType(boardDto.getBoardType());
        board.setBoardStatus(boardDto.getBoardStatus());
        board.setUser(user);
        board.countUp();

        return boardRepository.save(board).getId();
    }

    /**
     * 게시글 수정 B
     */
    @Transactional
    public Board updateBoard(Long boardId, Board board) {
        // 영속화
        // 일단 찾아내고, 못찾으면 예외 처리
        Board boardEntity = getBoard(boardId);

        // 영속화된 객체를 수정 - 더티체킹 (업데이트 완료)
        boardEntity.setTitle(board.getTitle());
        boardEntity.setContent(board.getContent());
        boardEntity.setBoardType(board.getBoardType());
        boardEntity.setBoardStatus(board.getBoardStatus());

        // 더티체킹으로 인한 자동 업데이트 완료 (JPA의 최대 장점)
        return boardEntity;
    }

    /**
     * 게시글 삭제
     */
    @Transactional
    public void deleteBoard(Long boardId) {
        getBoard(boardId); // 먼저 게시글을 조회하여 존재하는지 확인

        boardRepository.deleteById(boardId);
    }

    /**
     * 게시글 전체 가져오기
     */
    @Transactional
    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    /**
     * 게시글 가져오기
     */
    @Transactional
    public Board getBoard(Long boardId) {
        Board board = boardRepository.findById(boardId)
            .orElseThrow(() -> new CustomApiException("찾을 수 없는 게시글입니다."));
        return board;
    }

    /**
     * 게시글 제목으로 검색 가져오기
     */
    @Transactional
    public List<Board> getBoardsByTitleContaining(String keyword) {
        return boardRepository.findByTitleContaining(keyword);
    }

}
