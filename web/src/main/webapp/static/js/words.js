$(function () {

    $(".home-btn").click(function () {
        window.location = "/home";
    });

    var toDelete = 0;

    // UI for deleting
    $(".pair").click(function (ev) {
        var $target = $(ev.target);
        if (!$target.hasClass("dash") && !$target.hasClass("word")) {
            // ignore it
        } else if ($target.hasClass("dash")) {
            if ($target.hasClass("to-delete-no-line-throw")) {
                $target.removeClass("to-delete-no-line-throw");
                $target.siblings(".word").removeClass("to-delete");
                toDelete--;
            } else {
                $target.addClass("to-delete-no-line-throw");
                $target.siblings(".word").addClass("to-delete");
                toDelete++;
            }
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
        var $rusWord = $rusField.val();
        var $gerWord = $gerField.val();

        var data = {
            "russian": $rusWord,
            "german": $gerWord
        };

        $.ajax({
            url: 'add-words',
            type: 'POST',
            data: data
        }).done(function () {
            var $baseDiv = $("<div></div>");
            var $gerWordSpan = $("<span>" + $gerWord + "</span>");
            var $rusWordSpan = $("<span>" + $rusWord + "</span>");
            var $dashSpan = $("<span>" + " - " + "</span>");
            $gerWordSpan.addClass("word ger-word");
            $rusWordSpan.addClass("word rus-word");
            $dashSpan.addClass("dash");

            $baseDiv.append($gerWordSpan).append($dashSpan).append($rusWordSpan);
            $baseDiv.addClass('pair').prependTo($("#container"));
        }).always(function () {
            $rusField.val("");
            $gerField.val("");
            $gerField.focus();
        });
    });

    $(".delete-btn").click(function () {
        var wordsToDelete = [];
        $(".to-delete").each(function () {
            if ($(this).hasClass("ger-word")) {
                var gerWord = $(this)[0].innerText;
                wordsToDelete.push(gerWord);
                $(this).parent().hide();
            }
        });

        var data = {
            "words": JSON.stringify(wordsToDelete)
        };

        $.ajax({
            url: 'delete',
            type: 'POST',
            data: data
        });

        $(".delete-btn").css("background", "#EB8F8F");
    });


});