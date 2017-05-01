// function validateForm() {
//     var x = document.forms["vForm"]["vField1"].value
//     var y = document.forms["vForm"]["vField1"].value
//     if (x == null || x=="" || y==null || y==""){
//         alert("Поля не должны быть пустыми!")
//     }
// }

$(document).ready(function () {
    $("body").css("display", "none");

    $("body").fadeIn(600);

    $("a.fade").click(function (event) {
        event.preventDefault();
        linkLocation = this.href;
        $("body").fadeOut(600, redirectPage);
    });

    function redirectPage() {
        window.location = linkLocation;
    }
});
