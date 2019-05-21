<template>	
<div>
  <b-navbar toggleable="lg" type="dark" variant="dark">
    <b-navbar-brand href="PainelAdmin">Cinema UFC</b-navbar-brand>
	
    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>	

    <b-collapse id="nav-collapse" is-nav>      
      <b-navbar-nav class="ml-auto" >            
    
      
    	
        <b-nav-item @click="cadastrar">Cadastrar Filme</b-nav-item>    
      
		    <b-nav-item @click="dados">Dados</b-nav-item>          
      
        <b-nav-item-dropdown right>          
          <template slot="button-content"><em>Usuário</em></template>                    
            <b-dropdown-item href="/">Deslogar</b-dropdown-item>
          <!--
          <b-dropdown-item href="">Perfil</b-dropdown-item>
        -->
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>

</template>

<script >
export default {

  methods:{
    dados(){
      this.$router.push({name:'Dados'})
    },
    cadastrar(){
      this.$router.push({name:'CadastrarFilmes'})
    }

  }
}

</script>