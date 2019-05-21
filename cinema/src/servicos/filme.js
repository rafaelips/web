import {http} from "./config"


export default{

	post:(filme)=>{
		return http.post('filme',filme)
	},
	get:()=>{
		return http.get('filme/')
	}
}