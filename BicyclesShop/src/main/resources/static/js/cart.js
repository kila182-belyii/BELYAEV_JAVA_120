function deleteArticleFromCart(csrf, cartId, articleId) {
    let body = {
        "cartId": cartId,
        "articleId": articleId
    };
    const reload = function (response) {
        let cartHtml = document.getElementById('articles-list');

        let articlesListHtml = document.getElementById('articles-list');
        let newArticles = '<thead class="thead-dark">\n' +
            '        <tr>\n' +
            '            <th>ID</th>\n' +
            '            <th><@spring.message \'name\'/></th>\n' +
            '            <th><@spring.message \'price\'/></th>\n' +
            '            <th><@spring.message \'delete_from_cart\'/></th>\n' +
            '        </tr>\n' +
            '        </thead>';
        for (let i = 0; i < response.length; i++) {
            let cartArticleDto = response[i];
            newArticles += '<tr>';
            newArticles += '<td>' + cartArticleDto["articleId"] + '</td>'
            newArticles += '<td>' + cartArticleDto["name"] + '</td>';
            newArticles += '<td>' + cartArticleDto["price"] + '</td>';
            newArticles += '<td><a onclick="deleteArticleFromCart(\'' + csrf + '\', ' + cartArticleDto["cartId"] + ', ' + cartArticleDto["articleId"] + ')" href = "#"><@spring.message \'delete_from_cart\'/></a></td>';
            newArticles += '</tr>';
        }
        articlesListHtml.innerHTML = newArticles;
    };
    $.ajax({
        url: '/cart/delete',
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