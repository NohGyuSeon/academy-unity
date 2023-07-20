function searchAnswer(userId) {
  var answer = document.getElementById("find-answer").value;
  console.log("userId = " +  userId)
  findAnswer(userId, answer);
}

function findAnswer(userId, answer) {
  fetch(`/api/auth/findAnswer/${userId}?answer=${answer}`)
  .then(response => response.json())
  .then(data => {
    console.log(data)
    if (data.code == 1) {
      window.location.href = `/auth/passwordUpdate/${userId}`;
    } else {
      alert("정답이 틀렸습니다.")
    }
  })
  .catch(error => console.log("정답 검색 중 에러가 발생하였습니다: ", error));
}
