<template>	
  <div>
  <HomeInterno></HomeInterno>
    <b-container>
      <b-row align-h="center" class="mt-5">
        <b-col class="5">
          <b-card classe ="p-3">
            <!--INICIO-->            
             <div class="row">              
              <div class="col-lg-4">
                <center>
                  <img class="rounded-circle" src="../assets/Foto1.jpg" width="300px" height="300px" />
                  <h2>Rafael Silva</h2>
                  <p><i class="fas fa-envelope-open-text" />rafaelips34@gmail.com</p>
                </center>
                </div>               
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                <center>
                  <img class="rounded-circle" src="../assets/Foto2.jpg" width="300px" height="300px" />
                  <h2>Leonardo</h2>
                  <p><span class="glyphicon glyphicon-envelope"/> leonardosousa159@gmail.com</p>
                </center>
                </div>               
             </div> 
            <!--FIM-->
          </b-card>
        </b-col>
      </b-row>
    </b-container>

</div>
</template>
<script>
 
 import HomeInterno from './HomeInterno.vue'

 export default { 
  name:"Contatos",
    components: {    
     HomeInterno
  },
}
</script>