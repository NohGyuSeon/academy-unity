function updateProfile(userId, event) {
  event.preventDefault(); // 폼태그 액션 막기

  let data = $("#updateProfileForm").serialize(); // key=value

  console.log(data);

  $.ajax({
    type: "POST",
    url: "/api/user/updateProfile" + userId,
    data: data,
    contentType: "application/x-www-form-urlencoded; charset=utf-8",
    dataType: "json",
  }).done(res => { // HttpStatus 상태코드 200번대
    console.log("성공", res);
    // 사용자 수정이 성공한 경우 처리할 내용
    location.href = '/user/updateProfile/' + userId;
  }).fail(error => { // HttpStatus 상태코드 200번대 아닐 때
    if (error.data == null) {
      alert(error.responseJSON.message);
    } else {
      alert(JSON.stringify(error.responseJSON.data));
    }
  });
}

function goToProfile(userId) {
  window.location.href = "/user/profile/" + userId;
}
