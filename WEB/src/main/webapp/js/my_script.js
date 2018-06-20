$(document).ready(function () {

    $(".show_users").click(function () {
        $('.dinamic-table').empty()
        // $('.dinamic-table')
        // $('.div-table').append("<table class=\"table table-striped dinamic-table\">");
        $.getJSON("http://localhost:8080/users",function(response){
            var tblHTML ='<tr><th>First Name</th><th>Last Name</th><th>Age</th></tr>';
            $.each(response, function(i, item){
                tblHTML += '<tr><td>' + item.firstName + '</td><td>' + item.lastName + '</td><td>' + item.age + '</td></tr>';
            });
            $('.dinamic-table').append(tblHTML);
            // $('.dinamic-table').append('</table>');
        });

        $(".custom-container-users").removeClass('hide');
        $(".custom-container-products").addClass('hide');
        $(".custom-container-orders").addClass('hide');
    });

    $(".show_products").click(function () {
        $('.dinamic-table').remove();
        $('.div-table').append("<table class=\"table table-striped dinamic-table\">");
        $.getJSON("http://localhost:8080/products",function(response){
            var tblHTML ='<tr><th>Product</th><th>Category</th><th>Color</th><th>Cout in warehouse</th><th>Price</th><th>Gender</th><th>Size</th></tr>';
            $.each(response, function(i, item){
                tblHTML += '<tr><td>' + item.name + '</td><td>' + item.category + '</td><td>' + item.color + '</td><td>' + item.count + '</td><td>' + item.price + '</td><td>' + item.gender + '</td><td>' + item.size + '</td></tr>';
            });
            $('.dinamic-table').append(tblHTML);
            $('.dinamic-table').append('</table>');
        });

        $(".custom-container-users").addClass('hide');
        $(".custom-container-products").removeClass('hide');
        $(".custom-container-orders").addClass('hide');
    });

    $(".show_orders").click(function () {
        $(".custom-container-users").addClass('hide');
        $(".custom-container-products").addClass('hide');
        $(".custom-container-orders").removeClass('hide');
    });
});