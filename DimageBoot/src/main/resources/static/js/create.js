new Vue({
  el: '#staffcd',
  data () {
    return {
      staff_cd:"",
    }
  },
  mounted () {
    axios
      .get('/api/get-max-staffcd')
      .then(response => { 
    	  	(this.staff_cd = response.data)
    	  })
  }
})

