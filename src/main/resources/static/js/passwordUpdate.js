function matchPassword(userId) {
  var password1 = document.getElementById("update-password1").value;
  var password2 = document.getElementById("update-password2").value;

  if (password1 == password2) {
    console.log("userId = " +  userId)
    updatePassword(userId, password1);
  } else {
    alert("입력하신 비밀번호가 서로 다릅니다. 다시 입력해주세요.");
  }
}

function updatePassword(userId, password1) {
  fetch(`/api/auth/updatePassword/${userId}?password=${password1}`)
  .then(response => response.json())
  .then(data => {
    console.log(data)
    alert("비밀번호가 변경되었습니다.");
    window.location.href = `/auth/signin`;
  })
  .catch(error => console.log("비밀번호 수정 중 에러가 발생하였습니다: ", error));
}
