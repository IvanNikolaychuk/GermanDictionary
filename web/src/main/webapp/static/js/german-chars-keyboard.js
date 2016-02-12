$(function () {
    var $gerField = $(".ger-field");
    $('.char').click(function () {
        var $clickedChar = $(this).text();
        var $textInGerField = $gerField.val();
        $gerField.val($textInGerField + $clickedChar);
        $gerField.focus();
    })
});