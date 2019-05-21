<template>
<div>
	<BarraAdmin></BarraAdmin>
	<b-container>
		<b-row align-h="center" class="mt-5">
			<b-col class="5">
				<b-card classe ="p-3">
					<center>
					  <h4 class ="mb-4">Votações</h4>
					  <TabelaFilmes></TabelaFilmes>
					</center>
					</b-card>
				</b-col>
			</b-row>
		</b-container>



</div>
</template>

<script>
import TabelaFilmes from './TabelaFilmes.vue'
import BarraAdmin from './BarraAdmin.vue'


export default {
    components: {    
     BarraAdmin,
     TabelaFilmes
  },
  created: function(){
		
 }
  }
</script>