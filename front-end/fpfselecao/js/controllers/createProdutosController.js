app.controller("createProdutosController", function($scope, $http, $location){

    $scope.title = "Cadastrar Novo Produto";

    var carregarOrigens = function(){
        $http.get("http://localhost:8080/origens").then(function(response){
            $scope.origens = response.data;
        }).catch(function(){

        });
    };

    var carregarCategorias = function(){
        $http.get("http://localhost:8080/categorias").then(function(response){
            $scope.categorias = response.data;
        }).catch(function(){

        });
    };

    var validarProduto = function(produto){
        var errors = [];
        if (!produto) {
            errors.push({attribute: "produto", message: "Por favor, preencha os campos do formulário!"});
            return errors;
        }
        if (!produto.descricao) {
            errors.push({attribute: "descricao", message: "Por favor, insira uma descrição para o produto!"});
        }
        if (!produto.dataCompra) {
            errors.push({attribute: "dataCompra", message: "Por favor, insira a data da compra do produto!"});
        }
        if (!produto.preco) {
            errors.push({attribute: "preco", message: "Por favor, insira o preço do produto!"});
        }
        if (!produto.origem) {
            errors.push({attribute: "origem", message: "Por favor, selecione a origem do produto!"});
        }
        if (!produto.categoria) {
            errors.push({attribute: "categoria", message: "Por favor, selecione uma categoria para o produto!"});
        }
        return errors;
    }

    var str2date = function(str){
        var year = str.substring(6);
        var month = str.substring(3,5);
        var day = str.substring(0,2);
        return new Date(year, month-1, day);
    };

    $scope.adicionarProduto = function(produto){
        $scope.errors = validarProduto(produto);
        if ($scope.errors.length <= 0) {
            produto.dataCompra = str2date(produto.dataCompra);
            $http.post("http://localhost:8080/produtos", produto).then(function(response){
                delete $scope.produto;
                $location.path("/produtos");
            });
        }
    };

    $scope.redirectToList = function(){
        $location.path("/produtos");
    };

    carregarOrigens();
    carregarCategorias();
});