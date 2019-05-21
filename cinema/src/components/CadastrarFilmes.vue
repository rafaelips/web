<template>
	<div>
		<BarraAdmin></BarraAdmin>
		<b-container>
		<b-row align-h="center" class="mt-5">
			<b-col class="5">
				<b-card classe ="p-3">
					<center>
					<h3 class ="mb-4">Cadastrar Votação</h3>
					</center>
					<b-form >
						<b-alert
                			:show="dismissCountDown" dismissible  :variant="tipo" @dismiss-count-down="countDownChanged"
                			>{{informacao}}
              			</b-alert>
						<b-form  @submit="cadastrarFilmes" @reset="limpar">
							<center>
							<b-form-group id="input-group-1" label="1º Filme" label-for="input-1"/>
							</center>
							<b-form-group id="input-group-1" label="Nome do Filme" label-for="input-1">								
								<b-form-input
									v-model="form.primeiroNome"
    							    id="input-1"              								          							    
    							    required
    							    placeholder="Nome do Filme"
    							  ></b-form-input>
							</b-form-group>

							<b-form-file accept=".jpg, .png .jpeg"  		
							  v-model="form.arquivo1"						  
    						  :state="Boolean(form.arquivo1)"
    						  placeholder="Choose a file..."
    						  drop-placeholder="Drop file here..."
    						></b-form-file>

    						<center>
							<b-form-group id="input-group-2" label="2º Filme" label-for="input-2"/>
							</center>
							<b-form-group id="input-group-2" label="Nome do Filme" label-for="input-2">								
								<b-form-input
									v-model="form.segundoNome"
    							    id="input-2"              								          							    
    							    required
    							    placeholder="Nome do Filme"
    							  ></b-form-input>
							</b-form-group>

							<b-form-file accept=".jpg, .png .jpeg"    		
							  v-model="form.arquivo2"						  
    						  :state="Boolean(form.arquivo2)"
    						  placeholder="Choose a file..."
    						  drop-placeholder="Drop file here..."
    						></b-form-file>

    						<center>
							<b-form-group id="input-group-3" label="3º Filme" label-for="input-3"/>
							</center>
							<b-form-group id="input-group-3" label="Nome do Filme" label-for="input-3">								
								<b-form-input
									v-model="form.terceiroNome"
    							    id="input-3"              								          							    
    							    required
    							    placeholder="Nome do Filme"
    							  ></b-form-input>
							</b-form-group>

							<b-form-file accept=".jpg, .png .jpeg"    		
							  v-model="form.arquivo3"						  
    						  :state="Boolean(form.arquivo3)"
    						  placeholder="Choose a file..."
    						  drop-placeholder="Drop file here..."
    						></b-form-file>
						
						<br>
						<br>
						<b-button type="submit" variant="primary" > Cadastrar </b-button>
						&nbsp
						<b-button type="reset" variant="danger"> Limpar </b-button>							      
					</b-form>
					</b-form>
					
				</b-card>
			</b-col>
		</b-row>
	</b-container>

</div>


</template>

<script>
import BarraAdmin from './BarraAdmin.vue'
import FilmeService from '../servicos/filme.js'

export default {
components: {    
     BarraAdmin
},
data() {
      return {
      	tipo: '',              
        informacao:'',        
        dismissSecs: 3,
        dismissCountDown: 0, 
      	 form: {
        	arquivo1: null,
        	arquivo2: null,
        	arquivo3: null,
        	primeiroNome:'',
        	segundoNome:'',
        	terceiroNome:'',
    	}
			}
},
methods: { 
	cadastrarFilmes(evt){
       evt.preventDefault()
       

       let formData  = new FormData();
       formData.append('primeiroNome',this.form.primeiroNome)
       formData.append('segundoNome',this.form.segundoNome)
       formData.append('terceiroNome',this.form.terceiroNome)
       formData.append('arquivo1',this.form.arquivo1)
       formData.append('arquivo2',this.form.arquivo2)
       formData.append('arquivo3',this.form.arquivo3)
       
       FilmeService.post(formData).then(Response=>{       		
       		console.log(Response.data)
       		if(Response.data != null){
       		  this.informacao = "Cadastro Realizado com sucesso!";
              this.tipo="success";  
              this.limparDados();            
              this.showAlert();
       		}else{

       			this.informacao = "Erro ao tentar Cadastrar filmes"
       			this.tipo="warning";               
        		this.showAlert();
       		}
       }).catch(e=>{
         	 this.informacao = "Erro ao consultar o banco!"
             this.tipo="danger";               
             this.showAlert();              
         })
   	},
       limpar(evt){
		evt.preventDefault()
			this.limparDados();	
       }

	},
	limparDados(){
		this.form.arquivo1 = null
		this.form.arquivo2 = null
		this.form.arquivo3 = null
		
		this.form.primeiroNome =''
		this.form.segundoNome= ''
		this.form.terceiroNome = ''
	},
	countDownChanged(dismissCountDown) {
        this.dismissCountDown = dismissCountDown
     },
     showAlert() {          
        this.dismissCountDown = this.dismissSecs
      }   
}

</script>


