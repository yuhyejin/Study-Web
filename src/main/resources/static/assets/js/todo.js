var totalpage = 1;
var nowpage = 1;

function getToday() {
    var date = new Date();
    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);

    return year + "-" + month + "-" + day;
}


// 다음 페이지
function next() {
    if (nowpage < totalpage) {
        nowpage = nowpage + 1;
        loadToDo(nowpage);
    } else {
        alert("마지막 페이지 입니다.");
    }
}

// 이전 페이지
function before() {
    if (nowpage <= totalpage && nowpage > 1) {
        nowpage = nowpage - 1;
        loadToDo(nowpage);
    } else {
        alert("첫 페이지 입니다.");
    }
}


$('#addtodo').click(function () {
//    const email = sessionStorage.getItem('loginEmail');
    const title = $('#title').val();
    const desc = $('#desc').val();
    const priority = $('input[name="inlineRadioOptions"]:checked').val();
    const curcal = getToday();
    console.log('modal  ' + '/' + title + '/' + desc + '/' + priority + '/' + curcal);

    if (title == '') {
        alert('할 일을 입력하세요');
    }

    var JSONData = {'title': title, 'description': desc, 'priority': priority, 'curcal': curcal};

    $.ajax({
        type: 'post',
        url: '/todo/inserttodo',
        data: JSON.stringify(JSONData),
        contentType: 'application/json',
        success: function (data) {
            console.log('통신성공' + data);
            if (data === 'InsertSuccess') {
                alert("추가 되었습니다.");
                console.log('등록 완료');
                $('#title').val(title);
                $('#desc').val(desc);
                $('input[name="inlineRadioOptions"]:checked').val(priority);
                $('#curcal').val(curcal);
                $("#title").val('');
                $("#desc").val('');
                $('input[name="inlineRadioOptions"]').prop("checked", false);
                $('#myModal').modal('toggle');

                getList();
            } else {
                alert('로그인 이후 이용해주세요.');
                console.log('할 일 등록 실패');
            }
        },
        error: function () {
            alert('통신실패');
        }
    });

});

function getList() {

    $.ajax({
        type: 'GET',
        url: 'todo/todoList',
        dataTypeL: 'application/json',
        success: function (data) {
            console.log('리스트 됐다!?');
            var json = JSON.parse(data.trim());

            for (var i = 0; json.length > i; i++) {
                $("tbody").append("<tr>+" +
                    "<td>" + json[i].title + "</td>" +
                    "<td>" + json[i].description + "</td>" +
                    "<td>" + json[i].priority + "</td>" +
                    "<td>" + json[i].curcal + "</td>" +
                    "</tr>");
            }
            /*
                         let str='<div>'
                         str += "<div class='todo-header'>";
                         str += "<div class='custom-control form-control-lg custom-checkbox col-sm-7 todo-header-item'>";
                         str+="<input type='checkbox' class='custom-control-input todo-header-item' id='customCheck1' value= 1>";
                         str+="<label class='custom-control-label todo-header-item' for='customCheck1'><h5 class='title title1'><p>" + result.title + "</p> </h5></label>";
                         str+="<span class='todo-header-item col-sm-2 dead-line-date created-date1'>" + result.curcal+ "</span>";
                         str+="<span class='todo-header-item col-sm-2 dead-line-date dead-line-date1'>" + result.priority + "</span>";
                         str+="</div>";
                         str+="<div class='todo-desc desc1'>";
                         str+="<p>"  + result.description + "</p>"
                         str+="</div>";
                         str+="<div class='todo-btn'>";
                         str+="<button type='button' class='btn btn-outline-dark' onclick='deleteTodo(1);'>삭제</button>";
                         str+="</div>";
                         str+="</div>";
                         $('#todo-div').append(str);
             */
        }

    })
}


