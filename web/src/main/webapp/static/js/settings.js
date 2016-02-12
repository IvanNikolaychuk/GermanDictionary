$(function () {
    $(".home-btn").click(function () {
        window.location = "/home";
    });

    $(".apply-btn").click(function () {
        var correctAnswersVal = $(".input-val").val();
        if (!$.isNumeric(correctAnswersVal)) {
            alert('Please, provide a correct number.');
        } else {
            var data = {
                "correctAnswersDeleteRequirement": correctAnswersVal
            };

            $.ajax({
                url: 'settings',
                type: 'POST',
                data: data
            }).success(function() {
                alert('Settings applied.');
                window.location = "/home";
            });
        }
    });

});