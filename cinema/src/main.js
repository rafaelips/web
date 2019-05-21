import Vue from 'vue'
import App from './App.vue'
import BootstrapVue from 'bootstrap-vue'
import VueResource from 'vue-resource'


import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import BAlert from 'bootstrap-vue/es/components/alert/alert'
import Alert from 'bootstrap-vue/es/components/alert'

import VueRouter from 'vue-router'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faCoffee } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

//Componentes
import Login from './components/Login.vue'
import Home from  './components/Home.vue'
import Cadastrar from './components/Cadastrar.vue'
import Contados  from './components/Contados.vue'
import PainelAdm from './components/PainelAdm.vue'
import CadastrarFilmes from './components/CadastrarFilmes.vue'
import Dados from './components/Dados.vue'

library.add(faCoffee)
Vue.component('b-alert', BAlert)

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.use(VueResource)
Vue.use(Alert)
Vue.use(BootstrapVue)
Vue.use(VueRouter)


const routes =  [	
	{path:"*", component:Home}, // Pode ser colocado para ir para pagina de 404 erro
	{path:"/", component:Home},
	{path:"/Login", name:"Login", component:Login},
	{path:"/Cadastrar", name:"Cadastrar", component:Cadastrar},
	{path:"/Contados", name:"Contados", component:Contados},
	{path:"/PainelAdm/:usuario", name:"PainelAdm",component: PainelAdm, props:true},
	{path:"/PainelAdm/CadastrarFilmes", name:"CadastrarFilmes", component: CadastrarFilmes},
	{path:"/PainelAdm/Dados", name:"Dados", component: Dados}	
]
const router = new VueRouter({
	routes,
	mode:'history'
});


new Vue({
	router,
	render: h => h(App),  
}).$mount('#app');