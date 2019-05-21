import axios from "axios"


export const http = axios.create({
    baseURL: 'http://10.5.30.42:8080/rest_persistence/api/',
     headers: {
     		Accept: 'application/json',
    	   'Content-Type': 'application/json'
  },
})
