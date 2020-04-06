new Vue({
  el: '#app',
  data () {
    return {
      users: []
    }
  },
  mounted () {
    axios
      .get('/api/user-list-API')
      .then(response => (this.users = response.data))
  }
})



