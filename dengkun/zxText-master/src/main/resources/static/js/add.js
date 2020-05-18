
$(function () {
    var transactionId = $("#transactionId");
    var securityCode = $("#securityCode");
    var quantity = $("#quantity");
    var status = $("#status");
    var type = $("#type");
    $("#sb").click(function () {

        if (transactionId.val() === null || transactionId.val() === "") {
            alert("请填写transactionId");
            return;
        }
        if (securityCode.val() === null || securityCode.val() === "") {
            alert("请填写securityCode");
            return;
        }
        if (quantity.val() === null || quantity.val() === "") {
            alert("请填写quantity");
            return;
        }
        
        if (status.val() === null || status.val() === "") {
            alert("请填写status");
            return;
        }
        
        if (type.val() === null || type.val() === "") {
            alert("请填写type");
            return;
        }
       
        $("form").submit();
    });

    $("#back").click(function () {
        history.back(-1);
    })
});