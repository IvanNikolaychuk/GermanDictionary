$(function () {
    var $rusWord = $(".rus-word");
    var $gerWord = $(".ger-word");

    $gerWord.focus();
    $("#add-words-btn").click(function () {
        var data = {
            "russian": $rusWord.val(),
            "german":  $gerWord.val()
        };
        $.ajax({
            url: 'add-words',
            type: 'POST',
            data: data,
            success: function () {
                $rusWord.val("");
                $gerWord.val("");
                $gerWord.focus();
            }
        }).send();
    });
});