function executeSearch() {
  var keyword = document.getElementById("search-input").value;
  searchMagazines(keyword);
}

function searchMagazines(keyword) {
  fetch(`/api/admin/search?keyword=${keyword}`)
  .then(response => response.json())
  .then(data => {
    console.log(data);
    window.location.href = `/admin/manage?keyword=${keyword}`; // 검색어를 포함한 URL로 리다이렉트
  })
  .catch(error => console.log("메거진 검색 중 에러가 발생하였습니다: ", error));
}
