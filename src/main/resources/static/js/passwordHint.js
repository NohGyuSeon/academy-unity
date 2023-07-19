function searchAnswer(userId) {
  var answer = document.getElementById("find-answer").value();
  findAnswer(userId, answer);
}

function findAnswer(userId, answer) {
  fetch(`api/auth/findAnswer?answer=${answer}`)
  .then(response => response.json())
  .then(data => {
    console.log(data)
    window.location.href = `api/auth/findPassword/${userId}?answer=${answer}`;
  })
  .catch(error => console.log("정답 검색 중 에러가 발생하였습니다: ", error));
}
