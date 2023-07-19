function searchEmail() {
  var email = document.getElementById("find-email").value;
  findEmail(email);
}

function findEmail(email) {
  fetch(`api/auth/findEmail?email=${email}`)
  .then(response => response.json())
  .then(data => {
    console.log(data)
    window.location.href = `auth/passwordHint?email=${email}`;
  })
  .catch(error => console.log("이메일 검색 중 에러가 발생하였습니다: ", error));
}
