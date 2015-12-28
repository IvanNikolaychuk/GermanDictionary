$(function () {

    $(".home-btn").click(function () {
        window.location = "/home";
    });

    //$("input[type='text']").focus(function (ev) {
    //    $(ev.target).removeAttr('placeholder');
    //});

    var toDelete = 0;

    // UI for deleting
    $(".pair").click(function (ev) {
        var $target = $(ev.target);
        if (!$target.hasClass("word")) {
            //do nothing
        } else {
            if ($target.hasClass("to-delete")) {
                $target.removeClass("to-delete");
                $target.siblings(".word").removeClass("to-delete");
                $target.siblings(".dash").removeClass("to-delete-no-line-throw");
                toDelete--;
            } else {
                $target.addClass("to-delete");
                $target.siblings(".word").addClass("to-delete");
                $target.siblings(".dash").addClass("to-delete-no-line-throw");
                toDelete++;
            }
        }
        checkDeleteBtn();
    });

    function checkDeleteBtn() {
        var $deleteBtn = $(".delete-btn");
        if (toDelete > 0) {
            $deleteBtn.css("background", "#ED6B6B");
        } else {
            $deleteBtn.css("background", "#EB8F8F");
        }
    }

    var $rusField = $(".rus-field");
    var $gerField = $(".ger-field");
    $gerField.focus();

    $("#add-words-btn").click(function () {
        var data = {
            "russian": $rusField.val(),
            "german":  $gerField.val()
        };
        $.ajax({
            url: 'add-words',
            type: 'POST',
            data: data
        }).always(function() {
            $rusField.val("");
            $gerField.val("");
            $gerField.focus();
        });
    });
});