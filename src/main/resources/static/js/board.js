function confirmDelete(userId, boardId) {
  if (confirm("게시글을 삭제하시겠습니까?")) {
    deleteBoard(userId, boardId);
  }
}

function deleteBoard(userId, boardId) {
  $.ajax({
    url: "/api/user/deleteBoard/" + userId + "/" + boardId,
    type: "DELETE",
    success: function() {
      window.location.href = "/user/main";
    },
    error: function(xhr, status, error) {
      console.log("Error occurred while deleting board:", error);
    }
  });
}

function goToUpdateBoard(userId, boardId) {
  window.location.href = "/user/updateBoard/" + userId + "/" + boardId;
}
