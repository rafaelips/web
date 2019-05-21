<template>
<div>
	<BarraAdmin></BarraAdmin>
	<b-container>
		<b-row align-h="center" class="mt-5">
			<b-col class="5">				
					<center>
					<h3 class ="mb-4">Bem vindo {{usuario.nome}} {{usuario.sobrenome}}</h3>
					</center>
				
			</b-col>
		</b-row>
	</b-container>
</div>
</template>

<script >
import BarraAdmin from './BarraAdmin.vue'


export default {
	
	props: ['usuario'],

    components: {    
     BarraAdmin
  }
  }
</script>