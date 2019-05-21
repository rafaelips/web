<template>
<div>
<b-container>
	<b-row align-h="center" class="mt-5">
		<b-col class="5">
			<b-card classe ="p-3">
					<center><h3 class ="mb-4">Votação</h3></center>
					<div class="row">          					    
              			<div class="col-lg-4">
              				<center>	
              				  <img class="rounded-circle" src="../assets/avatar.jpg" width="200" height="200px""/>
              				  <p>Avatar</p>
              				  <b-progress :value="valueFoto1" :max="max"  show-value class="mb-3"/>
                        <b-button type="submit" variant="primary">Votar</b-button>
              				</center>
              			</div>
                    
              			<div class="col-lg-4">
              				<center>	
              				  <img class="rounded-circle" src="../assets/vingadores.jpg" width="200" height="200px""/>
              				  <p>Vingadores</p>
              				  <b-progress :value="valueFoto2" :max="max"  show-value class="mb-3"/>
                        <b-button type="submit" variant="primary">Votar</b-button>
              				</center>
              			</div>

              			<div class="col-lg-4">	
              				<center>	
              				  <img class="rounded-circle" src="../assets/titanic.jpg" width="200" height="200px""/>
              				  <p>Titanic</p>
              				  <b-progress :value="valueFoto3" :max="max"  show-value class="mb-3"/>
                        <b-button type="submit" variant="primary">Votar</b-button>
              				</center>
              			</div>
              		</div>
			</b-card>
		</b-col>
	</b-row>
</b-container>

</div>
</template>


<script>

export default {
    data() {
      return {  
      	max:100,      
        valueFoto1: 34,
        valueFoto2: 10,
        valueFoto3: 25,
      }
    }
  }

</script>