
var app = angular.module('appManager', []);

app.controller('BoardController', function($scope, $http) {

    $scope.init = function() {
        ws.init();
    };

    var services = [
        '/project/',
        '/task/'
    ];

    var METHODS = {
        GET: 'GET',
        PUT: 'PUT',
        POST: 'POST',
        DELETE: 'DELETE'
    };

    function fetch(object, successCallback, errorCallback) {
        if (!object.method) {
            object.method = 'GET';
        }

        $http({
            method: object.method,
            url: object.url,
            data: object.data
        })
        .then(function(response) {
            if (response.data) {
                successCallback(response.data);
            }
        },
        function(error) {
            console.log(error);
        });
    }

    var ws = {
        stompClient: null,
        init: function() {
            ws.connect();
        },
        connect: function() {
            var socket = new SockJS('/chat');
            ws.stompClient = Stomp.over(socket);
            ws.stompClient.connect({}, function(frame) {
                ws.subscribe();
            });
        },
        subscribe: function(){
            ws.stompClient.subscribe('/topic/messages', function(message) {

            });
        }
    };

});