var totalpage = 1;
var nowpage = 1;

function getToday(){
    var date = new Date();
    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);

    return year + "-" + month + "-" + day;
}



// 다음 페이지
function next(){
    if(nowpage < totalpage){
        nowpage = nowpage + 1;
        loadToDo(nowpage);
    }else{
        alert("마지막 페이지 입니다.");
    }
}
// 이전 페이지
function before() {
    if(nowpage <= totalpage && nowpage > 1){
        nowpage = nowpage - 1;
        loadToDo(nowpage);
    }else{
        alert("첫 페이지 입니다.");
    }
}



$('#addtodo').click(function() {
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
                $('input[name="inlineRadioOptions"]').prop("checked" , false);
                $('#myModal').modal('toggle');

                document.getElementById("title1").innerHTML = title;
                document.getElementById("desc1").innerHTML = desc;
                document.getElementById("priority8").innerHTML = priority;
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
/*
getList();

function getList() {
    const taskid = $(TaskDto.)
    const title = $('#title').val();
    const desc = $('#desc').val();
    const priority = $('input[name="inlineRadioOptions"]:checked').val();

    $.getJSON(
        "<c:url value='/todo/todoList/'/>"+taskid,
        function (data) {
            if (data.total>0) {
                var list = data.list;

                var todo_html = "<div>";
                for(i=0; i<list.length; i++) {
                    var title = list
                }
            }
        }
    )
}

 */
