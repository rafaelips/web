<template>
	<BarraAdmin></BarraAdmin>
	<b-container>
		<b-row align-h="center" class="mt-5">
			<b-col class="5">
				<b-card classe ="p-3">
					<h3 class ="mb-4">Dados</h3>
					<b-form >
						<b-form >							
							<b-form-group id="input-group-1" label="nome" label-for="input-1">
								<b-form-input
    								      id="input-1"              				
                          				v-model="usuario.nome"
    								      required
    								      placeholder="nome"
    								    >{{
    								    	usuario.nome
    								    }}</b-form-input>
							</b-form-group>
						</b-form>						
					</b-form>

				</b-card>
			</b-col>
		</b-row>
	</b-container>
</template>
<script >
	import BarraAdmin from './BarraAdmin.vue'	
export default {
components: {    
     BarraAdmin
},
data() {
      return {
        usuario:{
            nome:'',
            sobrenome:'',
            senha:'',
            matricula:'',
            curso:'',
            tipo_usuario:'' 
        }
}
</script>