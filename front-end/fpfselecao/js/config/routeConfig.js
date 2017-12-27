app.config(function($routeProvider){
    $routeProvider.when("/produtos", {
        templateUrl: "views/produtos/list.html",
        controller: "listProdutosController"
    });
    $routeProvider.when("/produtos/create", {
        templateUrl: "views/produtos/create.html",
        controller: "createProdutosController"
    });
    $routeProvider.when("/produtos/:id", {
        templateUrl: "views/produtos/edit.html",
        controller: "editProdutosController"
    });
    $routeProvider.otherwise({
        redirectTo: "/produtos"
    });
});