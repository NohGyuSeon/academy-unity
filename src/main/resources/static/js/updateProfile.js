// 수정 중
function updateProfile(userId) {
  $.ajax({
    url: "/api/user/updateProfile/" + userId,
    type: "POST",
    success: function () {
      window.location.href = "/user/updateProfile/" + userId;
    },
    error: function (xhr, status, error) {
      console.log("게시판 수정 중 에러가 발생하였습니다: ", error);
    }
  });
}
