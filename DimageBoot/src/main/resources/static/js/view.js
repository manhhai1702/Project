new Vue({
  el: '#app',
  data () {
    return {
      users: [],
      id:''
    }
  },
  
  mounted () {
	  var url = window.location.href;
	  this.id = '1';
    axios
      .get('/api/user-view-API', {
    	  params:{
    		  'id': this.id
    	  }
      })
      .then(response => (this.users = response))
  }
})

