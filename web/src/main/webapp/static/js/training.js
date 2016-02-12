$(function () {
    var units;
    var poz;
    var $gerField =  $(".ger-field");
    $gerField.focus();

    $gerField.keypress(function (e) {
        if (e.which == 13) {
            // enter
            $('.answer-btn').click();
            return false;
        }
    });

    $(".home-btn").click(function () {
        window.location = "/home";
    });

    $(".help-btn").click(function () {
        if (!trainingIsOver()) {
            $(".ger-field").val(units[poz].wordPair.germanWord.value);
            $(".ger-field").focus();
        }
        units[poz].correctAnswers = 0;
    });

    $.ajax({
        url: 'training',
        type: 'POST',

        success: function (data) {
            units = JSON.parse(data);
            poz = 0;
            getNextPair();
        }
    });

    var getNextPair = function () {
        if (trainingIsOver()) {
            alert('training is over');
            window.location = "/home";
            var data = {
                "words": JSON.stringify(units)
            };

            $.ajax({
                url: 'update',
                type: 'POST',
                data: data
            });
        } else {
            var pair = units[poz].wordPair;
            $(".rus-field").val(pair.russianWord.value);
        }
    };


    $(".answer-btn").click(function () {
        var $gerWord = $('.ger-field');
        check($gerWord.val());
        $gerWord.val("");
        $gerWord.focus();
    });

    function check(gerWord) {
        var expected = units[poz].wordPair.germanWord.value;
        if (gerWord === expected) {
            units[poz].correctAnswers++;
            poz++;
            getNextPair();
        } else {
            units[poz].correctAnswers = 0;
        }
    }


    var trainingIsOver = function () {
        if (units == undefined || poz == units.length) {
            return true;
        }
    };

});