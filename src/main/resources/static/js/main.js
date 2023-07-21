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
