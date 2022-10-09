/*
<script src = "static/bootstrap/js/jquery-1.10.2"></script>

$(document).ready(function () {
    $("#subadd_btn").on('click', function() {
        subjectadd();
    });
});
*/
<script src="stopwatch.js"></script>

function subjectadd() {
    let subject = prompt("추가할 과목을 입력하세요.");

    if (subject == null || subject == "") {
        alert("다시 입력해 주세요.");
    } else {
        alert("추가 되었습니다.");
    }

    document.getElementById("subject").innerHTML = subject;
/*
    $.ajax({
        url: "SubjectController",
        type: "POST",
        data: JSON.stringify(subject),
        contentType: "application/json; charset=utf-8;",
        dataType: "json",
        success: function(data){
            for(var i=0; i<data.length; i++){
                var tag = "<tr>" +
                    "<td>" + data.data[i].subjectname + "</td>"
                $('#subject').append(data[i] + "<br>");
            }
        },
        error: function(){
            alert("restController err");
        }
    });

 */
}