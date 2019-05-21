import {http} from "./config"


export default{

    post:(usuario)=>{
         return http.post('usuarios', usuario)
          
    }

}