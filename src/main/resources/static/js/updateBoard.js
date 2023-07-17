function updateBoard(userId, boardId) {
  $.ajax({
    url: "/api/user/updateBoard/" + userId + "/" + boardId,
    type: "POST",
    data: {
      title: $("input[name='title']").val(),
      content: $("textarea[name='content']").val(),
      boardType: $("select[name='boardType']").val(),
      boardStatus: $("select[name='boardStatus']").val()
    },
    success: function(response) {
      // 게시글 수정이 성공한 경우 처리할 내용
      window.location.href = "/user/board/" + userId + "/" + boardId;
    },
    error: function(xhr, status, error) {
      console.log("게시글 수정 중 에러가 발생하였습니다: ", error);
    }
  });
}
