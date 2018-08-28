$(document).ready(function () {

    $(".show_users").click(function () {
        $.getJSON("/users",function(response){
            var tblHTML ='<tr><th>First Name</th><th>Last Name</th><th>Age</th></tr>';
            $.each(response, function(i, item){
                tblHTML += '<tr><td>' + item.firstName + '</td><td>'
                    + item.lastName + '</td><td>' + item.age + '</td></tr>';
            });
            $('.users-table').html(tblHTML);
        });

        $(".custom-container-users").removeClass('hide');
        $(".custom-container-products").addClass('hide');
        $(".custom-container-orders").addClass('hide');
    });

    $(".show_products").click(function () {
        $.getJSON("/products",function(response){
            var tblHTML ='<tr><th>Product</th><th>Category</th><th>Color</th><th>Cout in warehouse</th>'
                           + '<th>Price</th><th>Gender</th><th>Size</th></tr>';
            $.each(response, function(i, item){
                tblHTML += '<tr><td>' + item.name + '</td><td>' + item.category + '</td><td>' + item.color
                        + '</td><td>' + item.count + '</td><td>' + item.price + '</td><td>' + item.gender
                        + '</td><td>' + item.size + '</td></tr>';
            });

            $('.products-table').html(tblHTML);
        });

        $(".custom-container-users").addClass('hide');
        $(".custom-container-products").removeClass('hide');
        $(".custom-container-orders").addClass('hide');
    });

    $(".show_orders").click(function () {
        $.getJSON("/orders",function(response){
            var tblHTML ='<tr><th>Order #</th><th>User</th><th>Products in order</th>';

            $.each(response, function (i, ord) {
                var ordIndex = 1 + i;
                tblHTML += '<tr><td>' + ordIndex + '</td><td>' + ord.user.firstName + " " + ord.user.lastName + '</td><td>';
                $.each(ord.products, function (pi, prod) {
                    tblHTML += prod.name + '<br>'
                });
                tblHTML += '</td></tr>';
            });
            $('.orders-table').html(tblHTML);
        });
        $('.orders-table').css('align', 'center');
        $(".custom-container-users").addClass('hide');
        $(".custom-container-products").addClass('hide');
        $(".custom-container-orders").removeClass('hide');
    });
});