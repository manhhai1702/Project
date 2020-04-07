new Vue({
  el: '#staffcd',
  data () {
    return {
      staffcd:"",
    }
  },
  mounted () {
    axios
      .get('/api/get-max-staffcd')
      .then(response => { 
    	  	(this.staffcd = response.data)
    	  })
  }
})


new Vue({
	  el: "#app",
	  data: {
	  	msg: '',
	  }
	 })

