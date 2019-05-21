<template>
	<div>

  <HomeInterno></HomeInterno>
  <Votacao></Votacao>

</div>

</template>

<script>
  import Votacao from './Votacao.vue'
  import HomeInterno from './HomeInterno.vue'

export default {
  name:"Home",
  components: {    
    Votacao,HomeInterno
  }
}

</script>