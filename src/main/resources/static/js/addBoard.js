// 게시글 등록 완료 시 메인 페이지로 이동
// function submitForm() {
//   // 게시글 등록 처리 로직
//   // ...
//
//   // 메인 페이지로 이동
//   location.href = '/user/main';ds aAss
// }

$(document).ready(function() {
  // 게시판 선택 이벤트 핸들러
  $(".board-select").change(function() {
    var selectedBoard = $(this).val();
    if (selectedBoard === "free") {
      // 자유게시판 선택 시 추가 동작 구현
      // ...
    } else if (selectedBoard === "parenting") {
      // 육아게시판 선택 시 추가 동작 구현
      // ...
    } else if (selectedBoard === "qna") {
      // 질문답변게시판 선택 시 추가 동작 구현
      // ...
    } else if (selectedBoard === "alert") {
      // 알림게시판 선택 시 추가 동작 구현
      // ...
    }
  });
});
