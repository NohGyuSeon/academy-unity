function confirmDelete(userId) {
  if (confirm("사용자를 삭제하시겠습니까?")) {
    deleteUser(userId);
  }
}

function deleteUser(userId) {
  $.ajax({
    url: "/api/user/deleteUser/" + userId,
    type: "DELETE",
    success: function() {
      window.location.href = "/user/main"; // 사용자 삭제 후, 로그인 페이지로 이동
    },
    error: function(xhr, status, error) {
      console.log("사용자 삭제 중 에러가 발생하였습니다: ", error);
    }
  });
}

function goToUpdateProfile(userId) {
  window.location.href = "/user/updateProfile/" + userId;
}
