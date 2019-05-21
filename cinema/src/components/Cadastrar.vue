<template>
<div>
	
  <HomeInterno></HomeInterno>
  
	<b-container>
		<b-row align-h="center" class="mt-5">
			<b-col class="5">
				<b-card classe ="p-3">
					<h3 class ="mb-4">Cadastrar</h3>
						<!--  Inicio do formulário-->  						
						<b-form >
              <b-alert
                :show="dismissCountDown" dismissible  :variant="tipo" @dismiss-count-down="countDownChanged"
                >{{informacao}}
              </b-alert>

                <b-form @submit="salvar" @reset="onReset" >
							<b-form-group id="input-group-1" label="Nome" label-for="input-1">
    								    <b-form-input
    								      id="input-1"              				
                          v-model="form.nome"
    								      required
    								      placeholder="nome"
    								    ></b-form-input>
      						</b-form-group>

      						<b-form-group id="input-group-2" label="Sobrenome" label-for="input-2">
    								    <b-form-input
    								      id="input-2"              				
                          v-model="form.sobrenome"
    								      required
    								      placeholder="Sobrenome"
    								    ></b-form-input>
      						</b-form-group>		

      						<b-form-group id="input-group-3" label="Mátricula" label-for="input-3">
    								    <b-form-input    								    
    								      id="input-3"      
                          v-model="form.matricula"        				
    								      required
    								      placeholder="Mátricula"
    								    ></b-form-input>
      						</b-form-group>


      						<b-form-group id="input-group-4" label="Senha" label-for="input-4">
    								    <b-form-input    	
                          type="password"							    
    								      id="input-4"      
                          v-model="form.senha1"        				
    								      required
    								      placeholder="Senha"
    								    ></b-form-input>
      						</b-form-group>

      						<b-form-group id="input-group-5" label="Senha novamente" label-for="input-4">
    								    <b-form-input    								    
    								    type="password"
    								      id="input-5" 
                          v-model="form.senha2"             				
    								      required
    								      placeholder="Senha"
    								    ></b-form-input>
      						</b-form-group>              
      						<b-button type="submit" variant="primary">Cadastrar</b-button>							&nbsp
                 <b-button type="reset" variant="danger"> Limpar </b-button>  
        
        </b-form >
                 <br>  <br>                
                 
						</b-form>            
              
				</b-card>
			</b-col>
		</b-row>
	</b-container>
</div>
</template>

<script>
 import HomeInterno from './HomeInterno.vue'
 import CadastrarService from '../servicos/cadastrarUsuario.js'
export default {	
  name:"Cadastrar",
    components: {    
     HomeInterno
  },
  data() {
      return {
        baseURL: 'http://localhost:8080/cinemaUFC/usuario',
        tipo: '',              
        informacao:'',        
        dismissSecs: 3,
        dismissCountDown: 0, 
        usuario:{
          nome:'',
          sobrenome:'',
          matricula:'',          
          senha:'',
        },
        form:{
          nome:'',
          sobrenome:'',
          matricula:'',          
          senha1:'',
          senha2:'',          
        },            	
      }
      
  	}, 
    methods:{ 
    salvar(evt){
      evt.preventDefault()
      if(this.form.senha1 == this.form.senha2){
          let formData = new FormData();
          formData.append('nome',this.form.nome);
          formData.append('sobrenome',this.form.sobrenome);
          formData.append('matricula',this.form.matricula);
          formData.append('senha',this.form.senha1);
          CadastrarService.post(formData).then(Response=>{          
          if(Response.data != null){
              this.informacao = "Cadastro Realizado com sucesso!";
              this.tipo="success";  
              this.limparDados();            
              this.showAlert();
              console.log(Response.data)
              this.$router.push('/Login');                    
            }else{
              this.informacao = "Usuário já matriculado com essa mátricula!"
              this.tipo="warning";               
              this.showAlert();
            }            
                              
          }).catch(e=>{
             this.informacao = "Erro ao consultar o banco!"
             this.tipo="danger";               
             this.showAlert();              
          })
      }else{
        this.informacao = "Senhas diferentes tente novamente";   
        this.tipo="warning";               
        this.showAlert();
      }
    },
    onReset(evt){
      evt.preventDefault()
          this.limparDados()  
        },
        limparDados(){
          this.form.nome =''
          this.form.sobrenome=''
          this.form.matricula=''
          this.form.senha1=''
          this.form.senha2=''
        },
      countDownChanged(dismissCountDown) {
        this.dismissCountDown = dismissCountDown
      },
      showAlert() {          
        this.dismissCountDown = this.dismissSecs
      }   
    }   
}
</script>


