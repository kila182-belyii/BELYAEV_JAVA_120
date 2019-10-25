function addArticleToCart(csrf, cartId, articleId) {
    let body = {
        "cartId": cartId,
        "articleId": articleId
    };
    const reload = function (response) {
        let cartHtml = document.getElementById('cart');
        cartHtml["innerHTML"] = '<a href="/cart?cartId='+ cartId + '" ><@spring.message \'cart\'/>(' + response + ') </a>';
    };
    $.ajax({
        url: '/cart',
        contentType: 'application/json',
        type: 'post',
        headers : {
            'X-CSRF-TOKEN': csrf
        },
        dataType: 'json',
        data: JSON.stringify(body),
        success: function (response) {
            reload(response);
        }
    })
}

function addArticle(csrf, name, price, type, cartId) {
    let body = {
        "name": name,
        "price": price,
        "type" : type
    };
    const reload = function (response) {
        $('#articles tr:last').after(
            '        <tr>\n' +
            '            <td>' + response["id"] + '</td>\n' +
            '            <td> ' + response["name"] + '</td>\n' +
            '            <td> ' + response["price"] + '</td>\n' +
            '            <td><a onclick="addArticleToCart(\'' + csrf + '\', ' + cartId + ', ' + response["id"] + ')" href = "#"><@spring.message \'add_to_cart\'/></a></td>\n' +
            '        </tr>'
        );
    };
    $.ajax({
        url: '/accessories/add',
        contentType: 'application/json',
        type: 'post',
        headers : {
            'X-CSRF-TOKEN': csrf
        },
        dataType: 'json',
        data: JSON.stringify(body),
        success: function (response) {
            reload(response);
        }
    })
}