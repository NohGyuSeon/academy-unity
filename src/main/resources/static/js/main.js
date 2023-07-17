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

function executeSearch() {
  var keyword = document.getElementById("search-input").value;
  searchBoards(keyword);
}

function searchBoards(keyword) {
  fetch(`/api/user/search?keyword=${keyword}`)
  .then(response => response.json())
  .then(data => {
    console.log(data);
    window.location.href = `/user/main?keyword=${keyword}`; // 검색어를 포함한 URL로 리다이렉트
  })
  .catch(error => console.log("게시판 검색 중 에러가 발생하였습니다: ", error));
}
