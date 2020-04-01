function hello() {
    console.log('hello function');
    console.log('/user/getUsers', 'right click and jump to user controller');
}

var vm = new Vue({
    data:{
        user: {}
    },
    methods: {
        query: function () {
            const url = '/user/getById?id=1';
            console.log("query function");
        },
        add: function(){
            console.log("add function");
        },
    }
});
