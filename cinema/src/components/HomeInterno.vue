
<template>
	<div>
  <b-navbar toggleable="lg" type="dark" variant="dark">
    <b-navbar-brand href="/">Cinema UFC</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>      
      <b-navbar-nav class="ml-auto">            
    	<b-nav-item href="#">Quem Somos</b-nav-item>
    	<b-nav-item href="Contados">Contatos</b-nav-item>
        <b-nav-item-dropdown right>
          <!-- Using 'button-content' slot -->
          <template slot="button-content"><em>Usuário</em></template>          
          <b-dropdown-item href="Cadastrar">Cadastre-se</b-dropdown-item>
          <b-dropdown-item href="Login">Login</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>

</div>

</template>

<script>
  
export default {
  name:"Home",  
}

</script>



