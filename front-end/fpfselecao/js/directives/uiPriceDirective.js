app.directive('uiPrice', [function () {
    return {
        require: "ngModel",
        link: function (scope, elem, attrs, ctrl) {
            if (!ctrl) return;

            var _formatNumber = function(number) {
                return number;
            };

            elem.bind("keyup", function(){
                ctrl.$setViewValue(_formatNumber(ctrl.$viewValue));
                ctrl.$render();
            });
        }
    };
}]);