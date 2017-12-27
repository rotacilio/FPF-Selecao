app.controller("listProdutosController", function($scope, $http, $location){

    $scope.title = "Listagem dos Produtos";

    var carregarProdutos = function(){
        $http.get("http://localhost:8080/produtos").then(function(data){
            $scope.produtos = data.data;
        }).catch(function(){

        });
    };

    $scope.apagarProduto = function(produto){
        console.log(produto);
        $http.delete("http://localhost:8080/produtos/"+(produto.id)).then(function(data){
            carregarProdutos();
        }).catch(function(){

        });
    };

    $scope.redirectToCreate = function(){
        $location.path("/produtos/create");
    };

    $scope.redirectToView = function(produto){
        $location.path("/produtos/"+(produto.id));
    };

    $scope.ordenarPor = function(campo){
        $scope.criterioOrdenacao = campo;
        $scope.reverse = !$scope.reverse;
    };

    carregarProdutos();
});
