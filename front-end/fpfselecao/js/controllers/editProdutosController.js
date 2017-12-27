app.controller("editProdutosController", function($scope, $http, $routeParams, $location){

    $scope.title = "Detalhes do Produto #" + $routeParams.id;

    var carregarProduto = function(id){
        $http.get("http://localhost:8080/produtos/"+id).then(function(response){
            $scope.produto = response.data;
            $scope.produto.dataCompra = _formatDate($scope.produto.dataCompra);
            // $scope.produtoForm.categoria = $scope.produto.categoria;
        }).catch(function(){

        });
    }

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

    var _formatDate = function(date){
        var year = date.substring(0,4);
        var month = date.substring(5,7);
        var day = date.substring(8);
        return day+"/"+month+"/"+year;
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

    $scope.apagarProduto = function(produto){
        $http.delete("http://localhost:8080/produtos/"+produto.id).then(function(data){
            $location.path("/produtos");
        }).catch(function(){

        });
    };

    $scope.redirectToCreate = function(){
        $location.path("/produtos/create");
    };

    $scope.redirectToList = function(){
        $location.path("/produtos");
    };

    $scope.salvarProduto = function(produto){
        $scope.errors = validarProduto(produto);
        if ($scope.errors.length <= 0) {
            produto.dataCompra = str2date(produto.dataCompra);
            $http.post("http://localhost:8080/produtos/update", produto).then(function(response){
                $location.path("/produtos");
            });
        }
    };

    carregarOrigens();
    carregarCategorias();
    carregarProduto($routeParams.id);
});