new Vue({
  el: '#app',
  data () {
    return {
     users:[],
     user_id:''
    }
    
  },
 
  mounted () {
	  var url = window.location.href;
	  var list = url.split("/");
	  this.user_id = list[4];
    axios
      .get('/api/user-view-API', {
    	  params:{
    		  'id': this.user_id,
    	  }
      })
      .then(response => { 
    	  	this.users = response;
//    	  	this.user_id= response.data.user_id;
//    	  	this.staffname = response.data.staff_name;
//    	  	this.staffcd = response.data.staff_cd;
//    	  	this.create_date = response.data.create_date;
    	  })
  }
})

new Vue({
	  el: "#app1",
	  data: {
	  	msg: '',
	  }
	 })
