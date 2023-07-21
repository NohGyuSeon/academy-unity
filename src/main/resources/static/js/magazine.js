function confirmDelete(userId, boardId) {
  if (confirm("게시글을 삭제하시겠습니까?")) {
    deleteMagazine(userId, boardId);
  }
}

function deleteMagazine(userId, magazineId) {
  $.ajax({
    url: `/api/admin/deleteMagazine/${userId}/${magazineId}`,
    type: "DELETE",
    success: function() {
      window.location.href = `/admin/manage`;
    },
    error: function(xhr, status, error) {
      console.log("메거진 삭제 중 에러가 발생하였습니다: ", error);
    }
  });
}

function goToUpdateMagazine(userId, magazineId) {
  window.location.href = `/admin/updateMagazine/${userId}/${magazineId}`;
}
