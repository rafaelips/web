<template>
  <div>
    <center>
    <table class="table table-responsive" v-show="carregar">
      <thead>
        <tr>
          <th>Id</th>
          <th>1º  Filme</th>
          <th>Votação</th>
          <th>2º  Filme</th>
          <th>Votação</th>
          <th>3º  Filme</th>
          <th>Votação</th>          
          <th>Status</th>
          <th>Ações</th>
        </tr>
        </thead>

        <tbody>
          
            <tr :key="filme.id" v-for="filme of filmes">

                <td>{{filmes.id}}</td>
                <td>{{filmes.nome_filme1}}</td>
                <td>{{filmes.voto_filme1}}</td>
                <td>{{filmes.nome_filme2}}</td>
                <td>{{filmes.voto_filme2}}</td>
                <td>{{filmes.nome_filme3}}</td>
                <td>{{filmes.voto_filme3}}</td>
                <td>{{filmes.status}}</td>
                <td> <b-button type="submit" variant="primary" > Alterar </b-button>
                  &nbsp
                     <b-button type="submit" variant="primary" > Deletar</b-button>
                  </td>              
            </tr>
          
        </tbody>

      


    </table>
  </center>
  </div>
</template>

<script>
  import FilmeService from '../servicos/filme.js'
  export default {
    data() {
      return {
        carregar: false,
        filme :{
            nome_filme1:'',
            nome_filme2:'',
            nome_filme3:'',
            voto_filme1:'',
            voto_filme2:'',
            voto_filme3:'',
            status: ''
        },

        filmes: []
      }
    },
    created: function(){
      console.log("HELLO")
      this.getFilmes()
 },
  methods:{
    getFilmes(){
      FilmeService.get().then(Response=>{                
          console.log(Response.data.filme)                    
          this.filmes = Response.data.filme          
          this.carregar = true
      }).catch(e=>{
        console.log(e)
      })
      /*
      FilmeService.get().then(Response=>{ 
        console.log("HELLO")
        if(Response.date.filme.length > 0){
          console.log(Response.date.filme)
        }
      }).catch(e=>{ 
        console.log(e)
      })
    */
    }
  }
  }
</script>
