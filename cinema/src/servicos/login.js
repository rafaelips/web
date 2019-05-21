import {http} from "./config"


export default{

getUsuario:(matricula)=>{
	return http.get('usuarios/'+matricula)
}

}