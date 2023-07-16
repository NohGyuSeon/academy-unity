$(document).ready(function () {
  // 페이지 로드 시 AJAX 요청 전송
  $.ajax({
    url: "/user/boards",
    type: "GET",
    success: function (response) {
      // 요청이 성공적으로 처리된 경우
      console.log("게시글 리스트 가져오기 성공");
      // 서버에서 받은 데이터를 기반으로 리스트 업데이트
      updateBoardList(response);
    },
    error: function (xhr, status, error) {
      // 요청 처리 중 에러가 발생한 경우
      console.log("게시글 리스트 가져오기 실패");
      // 에러 처리 동작 구현
    }
  });
});

function updateBoardList(boards) {
  var boardListContainer = $("#board-list-container");
  boardListContainer.empty(); // 기존 리스트 내용 초기화

  // 서버에서 받은 게시글 데이터를 반복하여 리스트에 추가
  for (var i = 0; i < boards.length; i++) {
    var board = boards[i];
    var listItem = $("<li></li>");
    listItem.append("<h3>" + board.title + "</h3>");
    listItem.append("<p>" + board.content + "</p>");
    listItem.append("<p>" + board.boardType + "</p>");
    listItem.append("<p>" + board.boardStatus + "</p>");
    boardListContainer.append(listItem);
  }
}
