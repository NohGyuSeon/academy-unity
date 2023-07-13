package com.daonplace.springbootweb.service.user;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.Write;
import com.daonplace.springbootweb.domain.user.board.Board;
import com.daonplace.springbootweb.repository.user.BoardRepository;
import com.daonplace.springbootweb.repository.user.UserRepository;
import com.daonplace.springbootweb.repository.user.WriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WriteService {

    private final WriteRepository writeRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    /**
     * 게시글 작성
     */
    @Transactional
    public Long write(Long userId, Long boardId) {

        // 엔티티 조회
        User user = userRepository.findOne(userId);
        Board board = boardRepository.findOne(boardId);

        // 게시글 작성
        Write write = Write.createWrite(user, board);

        // 게시글 저장
        writeRepository.save(write);

        return write.getId();
    }

    /**
     * 게시글 작성 취소
     */
    public void cancelWrite(Long writeId) {
        // 게시글 작성 엔티티 조회
        Write write = writeRepository.findOne(writeId);

        // 게시글 작성 취소
        write.cancel();
    }

//    public List<Write> findWrites(WriteSearch writeSearch) {
//
//    }

}
