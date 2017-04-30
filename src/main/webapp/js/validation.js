function validateForm() {
    var x = document.forms["vForm"]["vField1"].value
    var y = document.forms["vForm"]["vField1"].value
    if (x == null || x=="" || y==null || y==""){
        alert("Поля не должны быть пустыми!")
    }
}
