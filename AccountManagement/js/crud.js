var addNew = false;
var username = "";
var password = "";
var search = "";
var arrayDepartment = [];
var arrayPosition = [];
var sortField = "id";
var isAsc = false;

function login() {
  username = $("#username").val();
  password = $("#password").val();
  var url = "http://localhost:8080/v2/api/accounts/login";

  url += "?username=" + username + "&password=" + password;
  $.ajax({
    url: url,
    type: "GET",
    success: function (result) {
      $(".content-body").load("home.html");
      getAllDepartment();
      getData();
    },
    error: function (data, status) {
      console.log("status = " + status + "  " + JSON.stringify(data));
      alert(data.responseJSON.message);
    },
  });
}

//
// var t = storage.getItem("USER_NAME");

$(document).ready(function () {
  // $("#logout").click(function () {

  // });
  $(".content-body").load("login.html");

  //getData();

  $('[data-toggle="tooltip"]').tooltip();
  var actions = $("table td:last-child").html();

  $(document).on("click", "#logout", function () {
    console.log("logout");
    //reset data
    username = "";
    password = "";
    //load man hinh login
    $(".content-body").load("login.html");
    // window.location.href = "../html/departmetn.html";
  });
  $(document).on("click", "#btn-goToAccount", function () {
    console.log("Hi");
    getData();
    $(".content-body").load("crud.html");
  });
  $(document).on("click", "#home", function () {
    console.log("WelcomeHome");
    $(".content-body").load("home.html");
  });

  $(document).on("click", ".add", function () {
    var empty = false;
    var input = $(this).parents("tr").find('input[type="text"]');
    input.each(function () {
      if (!$(this).val()) {
        $(this).addClass("error");
        empty = true;
      } else {
        $(this).removeClass("error");
      }
    });
    $(this).parents("tr").find(".error").first().focus();

    if (!empty) {
      var id,
        email,
        username,
        fullName,
        departmentName,
        positionName,
        createDate;
      var index = 1;
      input.each(function () {
        let value = $(this).val();
        $(this).parent("td").html(value);
        switch (index) {
          case 1: {
            id = value;
            break;
          }
          case 2: {
            email = value;
            break;
          }
          case 3: {
            username = value;
            break;
          }
          case 4: {
            fullName = value;
            break;
          }
          case 5: {
            departmentName = value;
            break;
          }
          case 6: {
            positionName = value;
            break;
          }
          case 7: {
            createDate = value;
            break;
          }
        }
        index++;
      });

      console.log(
        `email : ${email}, username : ${username}, fullName: ${fullName}, departmentName :${departmentName}, positionName:${positionName}, createDate : ${createDate}`
      );
      if (addNew == false) {
        updateAccount(
          id,
          email,
          username,
          fullName,
          departmentName,
          positionName,
          createDate
        );
      } else {
        addNew = false;
        createAccount(
          id,
          email,
          username,
          fullName,
          departmentName,
          positionName,
          createDate
        );
      }
      $(this).parents("tr").find(".add, .edit").toggle();
      $(".add-new").removeAttr("disabled");
    }
  });

  // Edit row on edit button click
  $(document).on("click", ".edit", function () {
    var id, uName, email, fName, dpName, psName;
    $(this)
      .parents("tr")
      .find("td:not(:last-child)")
      .each(function (index) {
        switch (index) {
          case 1:
            id = $(this).text();
            break;
          case 2:
            email = $(this).text();
            break;
          case 3:
            uName = $(this).text();
            break;
          case 4:
            fName = $(this).text();
            break;
          case 5:
            dpName = $(this).text();
            break;
          case 6:
            psName = $(this).text();
            break;
        }
      });
    console.log(
      `id = ${id}, uName = ${uName}, email = ${email}, fname = ${fName}, dpName = ${dpName},psName = ${psName}`
    );
    updatePopup(id, uName, email, fName, dpName, psName);
    // $(".add-new").attr("disabled", "disabled");
  });
  // Delete row on delete button click
  $(document).on("click", ".delete", function () {
    var idDelete = $(this).parents("tr").find("#td-id").text();
    deleteAccount(idDelete, $(this).parents("tr"));
  });
});
var accounts = [];
var currentPage = 1;
var size = 5;

//
function getData() {
  var url = "http://localhost:8080/v2/api/accounts";

  url += "?page=" + currentPage + "&size=" + size;
  url += "&sort=" + sortField + "," + (isAsc ? "asc" : "desc");

  if (search) {
    url += "&userName=" + search;
  }
  $.ajax({
    url: url,
    type: "GET",
    contentType: "application/json",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (data, status, xhr) {
      accounts = data.content;
      fillAccountToTable();
      // resetDeleteCheckbox();
      pagingTable(data.totalPages);
    },
    error: function (data, status) {
      alert("Error when loading data");
    },
  });
}

function pagingTable(pageAmount) {
  var pagingStr = "";

  if (pageAmount > 1 && currentPage > 1) {
    pagingStr +=
      '<li class="page-item">' +
      '<a class="page-link" onClick="prevPaging()">Previous</a>' +
      "</li>";
  }

  for (i = 0; i < pageAmount; i++) {
    pagingStr +=
      '<li class="page-item ' +
      (currentPage == i + 1 ? "active" : "") +
      '">' +
      '<a class="page-link" onClick="changePage(' +
      (i + 1) +
      ')">' +
      (i + 1) +
      "</a>" +
      "</li>";
  }

  if (pageAmount > 1 && currentPage < pageAmount) {
    pagingStr +=
      '<li class="page-item">' +
      '<a class="page-link" onClick="nextPaging()">Next</a>' +
      "</li>";
  }

  $("#pagination").empty();
  $("#pagination").append(pagingStr);
}

function resetPaging() {
  currentPage = 1;
  size = 5;
}

function resetSearch() {
  search = "";
}

function changeSort(field) {
  if (field == sortField) {
    isAsc = !isAsc;
  } else {
    sortField = field;
    isAsc = true;
  }
  buildTable();
}
function handleSearch() {
  var s = document.getElementById("input-search-account").value;

  console.log("data --> " + s);

  if (search != s) {
    search = s;
    buildTable();
  }
}

function prevPaging() {
  changePage(currentPage - 1);
  resetCheckBoxAll();
}

function nextPaging() {
  changePage(currentPage + 1);
  resetCheckBoxAll();
}

function changePage(page) {
  if (page == currentPage) {
    return;
  }
  resetCheckBoxAll();
  currentPage = page;
  buildTable();
}

function fillAccountToTable() {
  $("tbody").empty(); //reset du lieu trong tbody

  accounts.forEach(function (item, index) {
    $("tbody").append(
      "<tr>" +
        '<td><input id="checkbox-' +
        index +
        '"' +
        `type="checkbox" onClick="onChangeCheckboxItem(this ,${item.id})"></td>` +
        '<td id="td-id" style = "display:none">' +
        item.id +
        "</td>" +
        "<td>" +
        item.email +
        "</td>" +
        "<td>" +
        item.username +
        "</td>" +
        "<td>" +
        item.fullName +
        "</td>" +
        "<td>" +
        item.departmentName +
        "</td>" +
        "<td>" +
        item.positionName +
        "</td>" +
        "<td>" +
        item.createDate +
        "</td>" +
        "<td>" +
        '<a class="edit" title="Edit" data-toggle="tooltip">' +
        '<i class="material-icons">&#xE254;</i>' +
        "</a>" +
        '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' +
        item.id +
        ')"><i class="material-icons">&#xE872;</i></a>' +
        "</td>" +
        "</tr>"
    );
  });
}
function buildTable() {
  $("tbody").empty();
  getData();
}
function openAddModal() {
  openModal();
  resetFormAdd();
}

function resetFormAdd() {
  document.getElementById("titleModal").innerHTML = "Add Account";
  document.getElementById("id").value = "";
  document.getElementById("email").value = "";
  document.getElementById("username").value = "";
  document.getElementById("fullname").value = "";
  document.getElementById("departmentSelect").value = "1";
  var button = document.getElementById("bt-save");
  button.innerHTML = "Save";
  button.onclick = function () {
    save();
  };
}
function openModal() {
  $("#myModal").modal("show");
}

function hideModal() {
  $("#myModal").modal("hide");
}

/******* DELETE  *********/
function deleteAccount(id, elementTr) {
  console.log("id = " + id);
  $.ajax({
    url: "http://localhost:8080/v2/api/accounts/" + id,
    type: "DELETE",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (result) {
      // error
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }

      // success
      elementTr.remove();
      alert("Delete thanh cong");
      resetPaging();
      buildTable();
    },
    error: function (data, status) {
      if (data.status == 403) {
        alert("Tai khoan khong co quyen");
      }
    },
  });
}

// su ly su kien xoa nhieu checkbox
var listIdDelete = [];
function onChangeCheckboxItem(checkbox, id) {
  var value = checkbox.checked;
  if (value == true) {
    listIdDelete.push(id);
  } else {
    listIdDelete = listIdDelete.filter((item) => item != id);
  }
}

function resetCheckBoxAll() {
  document.getElementById("checkbox-all").checked = false;
  listIdDelete = [];
}

function onChangeCheckboxAll() {
  listIdDelete = [];
  var value = document.getElementById("checkbox-all").checked;
  console.log("CheckAll +" + value);
  // tao mang id xoa
  if (value) {
    accounts.forEach((element) => {
      listIdDelete.push(element.id);
    });
  }
  // check all item
  for (let i = 0; ; i++) {
    var checkboxItem = document.getElementById("checkbox-" + i);
    if (checkboxItem !== undefined && checkboxItem !== null) {
      checkboxItem.checked = value;
    } else {
      break;
    }
  }
}

function deleteAllAccount() {
  if (listIdDelete.length == 0) {
    return;
  }

  $.ajax({
    url: "http://localhost:8080/v2/api/accounts?ids=" + listIdDelete,
    type: "DELETE",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (result) {
      // error
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }
      alert("Delete  Accouts + " + JSON.stringify(listIdDelete));
      resetCheckBoxAll();
      resetPaging();
      buildTable();
    },
  });
}
/******* UPDATE  *********/

function updateAccount(
  id,
  email,
  username,
  fullName,
  departmentName,
  positionName,
  createDate
) {
  console.log(
    `new data = ${id} , ${email}, ${username}, ${fullName}, ${departmentName}, ${positionName}, ${createDate}`
  );
  $.ajax({
    url: "http://localhost:8080/v2/api/accounts/" + id,
    type: "PUT",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    contentType: "application/json",
    data: `{"email":"${email}","username":"${username}","fullName":"${fullName}", "departmentName" :"${departmentName}", "positionName":"${positionName}", "createDate": "${createDate}"}`,
    success: function (listData, status, xhr) {
      console.log("Update thành công");
    },
  });
}

/******* CREATE ACCOUNT  *********/

function createAccount(email, user_name, fullName, departmentId, positionId) {
  console.log(
    `new data =  ${email}, ${username}, ${fullName}, ${departmentId}, ${positionId}`
  );
  $.ajax({
    url: "http://localhost:8080/v2/api/accounts",
    type: "POST",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    contentType: "application/json",
    data: `{"email":"${email}","username":"${user_name}","fullName":"${fullName}", "departmentId" :"${departmentId}", "positionId":"${positionId}"}`,
    success: function (listData, status, xhr) {
      if (status == "success") {
        alert("Create thành công");
        getData();
        hideModal();
      }
    },
    error: function (data, status, xhr) {
      console.log(JSON.stringify(data));
      console.log(status + " <==>" + JSON.stringify(xhr));
      alert("Create that bai: " + data.responseJSON.data);
    },
  });
}
//
function save() {
  var username = document.getElementById("username").value;
  var email = document.getElementById("email").value;
  var fullname = document.getElementById("fullname").value;

  var selectorDepartment = document.getElementById("departmentSelect");
  var departmentID =
    selectorDepartment.options[selectorDepartment.selectedIndex].value;

  var positionSl = document.getElementById("positionSelect");
  var positionID = positionSl.options[positionSl.selectedIndex].value;

  createAccount(email, username, fullname, departmentID, positionID);
}

function resetFormUpdate() {
  document.getElementById("titleModal").innerHTML = "Update Account";
  document.getElementById("authorLabel").style.display = "block";
  document.getElementById("author").style.display = "block";
  document.getElementById("createdDateLabel").style.display = "block";
  document.getElementById("createdDate").style.display = "block";
  hideNameErrorMessage();
}
var oldName;

function submitUpdate(id) {
  var email = document.getElementById("email").value;
  var uName = document.getElementById("username").value;
  var fName = document.getElementById("fullname").value;
  var selectorDepartment = document.getElementById("departmentSelect");
  var departmentID =
    selectorDepartment.options[selectorDepartment.selectedIndex].value;

  var positionSl = document.getElementById("positionSelect");
  var positionID = positionSl.options[positionSl.selectedIndex].value;

  $.ajax({
    url: "http://localhost:8080/v2/api/accounts/" + id,
    type: "PUT",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    contentType: "application/json",
    data: `{"email":"${email}","username":"${uName}","fullName":"${fName}", "departmentId" :"${departmentID}", "positionId":"${positionID}"}`,
    success: function (listData, status, xhr) {
      //console.log("Update thành công");
      alert("Update thanh cong");
      getData();
      hideModal();
    },
    error: function (data, status, xhr) {
      alert("Update that bai");
    },
  });
}

function updatePopup(id, uName, email, fName, dpName, psName) {
  document.getElementById("titleModal").innerHTML = "Update Account";

  document.getElementById("email").value = email;
  document.getElementById("username").value = uName;
  document.getElementById("fullname").value = fName;

  var button = document.getElementById("bt-save");
  button.innerHTML = "update";
  button.onclick = function () {
    submitUpdate(id);
  };

  //var dpSelect = document.getElementById("departmentSelect");
  //get option value of select jquery
  $("#departmentSelect option").each(function () {
    var t = $(this).text();
    if (dpName.toLowerCase().trim() == t.toLowerCase().trim()) {
      //select option od seletect using jquery
      $(this).prop("selected", true);
      return false;
    }
  });
  $("#positionSelect option").each(function () {
    var s = $(this).text();
    if (psName.toLowerCase().trim() == s.toLowerCase().trim()) {
      //select option od seletect using jquery
      $(this).prop("selected", true);
      return false;
    }
  });

  openModal();
}

function getAllDepartment() {
  $.ajax({
    url: "http://localhost:8080/v1/api/departments",
    type: "GET",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (result) {
      arrayDepartment = result;
      fillDatatoDepartment(arrayDepartment);
    },
    error: function (data, status) {
      console.log("status = " + status + "  " + JSON.stringify(data));
      alert(data.responseJSON.message);
    },
  });
}
function getAllPosition() {
  $.ajax({
    url: "http://localhost:8080/v1/api/positions",
    type: "GET",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (result) {
      arrayPosition = result;
      fillDatatoPosition(arrayPosition);
    },
    error: function (data, status) {
      console.log("status = " + status + "  " + JSON.stringify(data));
      alert(data.responseJSON.message);
    },
  });
}

function fillDatatoDepartment(arrayDp) {
  $("#departmentSelect").empty();

  var text = "";
  arrayDp.forEach((element) => {
    text += `<option value="${element.id}">${element.name}</option>`;
  });

  $("#departmentSelect").html(text);
}
function fillDatatoPosition(arrayPs) {
  $("#positionSelect").empty();

  var text = "";
  arrayPs.forEach((element) => {
    text += `<option value="${element.id}">${element.name}</option>`;
  });

  $("#positionSelect").html(text);
}
