function updateBoard(userId, boardId, evssent) {
  event.preventDefault(); // 폼태그 액션 막기

  let data = $("#updateBoardForm").serialize(); // key=value

  console.log(data);

  $.ajax({
    type: "POST",
    url: '/api/user/updateBoard/' + userId + '/' + boardId,
    data: data,
    contentType: "application/x-www-form-urlencoded; charset=utf-8",
    dataType: "json"
  }).done(res => { // HttpStatus 상태코드 200번대
    console.log("성공", res);
    // 게시글 수정이 성공한 경우 처리할 내용
    location.href = '/user/board/' + userId + '/' + boardId;
  }).fail(error => { // HttpStatus 상태코드 200번대가 아닐 때
    if (error.data == null) {
      alert(error.responseJSON.message);
    } else {
      alert(JSON.stringify(error.responseJSON.data));
    }
  });
}

function goToBoard(userId, boardId) {
  window.location.href = "/user/board/" + userId + "/" + boardId;
}
