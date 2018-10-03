var app = angular.module("ContractManagement", []);

// Controller Part
app.controller("ContractController", function($scope, $http) {


    $scope.contracts = [];
    $scope.contractForm = {
        id: -1,
        series: "",
        number: "",
        typeContractId: "",
        dateSignature: "",
        dateStart: "",
        dateEnd: "",
        sumWithoutVAT: "",
        rateVAT: "",
        sumVAT: "",
        sumWithVAT: "",
        conformMinSum: "",
        vehicleId: "",
        comment: "",
    };

    // Now load the data from server
    _refreshContractData();

    // HTTP POST/PUT methods for add/edit employee
    // Call: http://localhost:8080/employee
    $scope.submitContract = function() {

        var method = "";
        var url = "";

        if ($scope.contractForm.id == -1) {
            method = "POST";
            url = '/contract';
        } else {
            method = "PUT";
            url = '/contract';
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.contractForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createContract = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteContract = function(contract) {
        $http({
            method: 'DELETE',
            url: '/contract/' + contract.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editContract = function(contract) {
        $scope.contractForm.id = contract.id;
        $scope.contractForm.series = contract.series;
        $scope.contractForm.number = contract.number;
        $scope.contractForm.typeContractId = contract.typeContractId;
        $scope.contractForm.dateSignature = contract.dateSignature;
        $scope.contractForm.dateStart = contract.dateStart;
        $scope.contractForm.dateEnd = contract.dateEnd;
        /*$scope.contractForm.sumWithoutVAT = contract.sumWithoutVAT;
        $scope.contractForm.rateVAT = contract.rateVAT;*/
        $scope.contractForm.sumVAT = contract.sumVAT;
        $scope.contractForm.sumWithVAT = contract.sumWithVAT;
        /*$scope.contractForm.conformMinSum = contract.conformMinSum;*/
        $scope.contractForm.vehicleId = contract.vehicleId;
        $scope.contractForm.comment = contract.comment;
    };


    function _refreshContractData() {
        $http({
            method: 'GET',
            url: '/contracts'
        }).then(
            function(res) { // success
                $scope.contracts = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshContractData();
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        $scope.contractForm.id = -1;
        $scope.contractForm.series = "";
        $scope.contractForm.number = "";
        $scope.contractForm.typeContractId = "";
        $scope.contractForm.dateSignature = "";
        $scope.contractForm.dateStart = "";
        $scope.contractForm.dateEnd = "";
        $scope.contractForm.sumVAT = "";
        $scope.contractForm.sumWithVAT = "";
        $scope.contractForm.vehicleId = "";
        $scope.contractForm.comment = "";
    };
});