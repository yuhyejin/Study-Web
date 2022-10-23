$('#addstudy').click(function() {
    const groupname = $('#groupname').val();
    const category = $('#category option:selected').val();
    const goaltime = $('#goaltime option:selected').val();
    const people = $('#people option:selected').val();
    const grouppassword = $('#grouppassword').val();
    const groupinfo = $('#groupinfo').val();
    console.log('modal  ' + '/' + groupname + '/' + category + '/' + goaltime + '/' + people + '/' + grouppassword + '/' + groupinfo);

    if (groupname == '') {
        alert('그룹을 입력하세요');
    }

    var JSONData = {'groupname': groupname, 'category': category, 'goaltime': goaltime, 'people': people, 'grouppassword': grouppassword, 'groupinfo': groupinfo};

    $.ajax({
        type: 'post',
        url: '/group/save-group',
        data: JSON.stringify(JSONData),
        contentType: 'application/json',
        success: function (data) {
            console.log('통신성공' + data);
            if (data === 'SaveSuccess') {
                alert("추가 되었습니다.");

                console.log('등록 완료');
                $('#groupname').val('');
                $('#category option:selected').remove();
                $('#goaltime option:selected').remove();
                $('#people option:selected').remove();
                $('#grouppassword').val('');
                $('#groupinfo').val('');
                $('#groupModal').modal('toggle');

                $("#add").load(window.location.href + "#add");

            } else {
                alert('로그인 이후 이용해주세요.');
                console.log('그룹 등록 실패');
            }
        },
        error: function () {
            alert('통신실패');
        }
    });

});

$('#group-add').click(function() {
    const groupId = $('#group_seq').val();

    const JSONData = {'group_seq': groupId};
    console.log("id = " + groupId);

    $.ajax({

        url:"/group/save-mygroup",
        data: JSON.stringify(JSONData),
        contentType: 'application/json',
        success: function (data) {
            console.log('통신성공' + data);
            if (data === 'hi') {
                alert("추가 되었습니다.");

                console.log('등록 완료');
                $('#groupname').val('');
                $('#category option:selected').remove();
                $('#goaltime option:selected').remove();
                $('#people option:selected').remove();
                $('#grouppassword').val('');
                $('#groupinfo').val('');
                $('#groupModal').modal('toggle');

                $("#add").load(window.location.href + "#add");

            } else {
                alert('로그인 이후 이용해주세요.');
                console.log('그룹 등록 실패');
            }
        },
        error: function () {
            alert('통신실패');
        }
    });

});