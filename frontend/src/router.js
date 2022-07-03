
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import Weather from "./components/Weather"


export default new Router({
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/',
                name: 'Weather',
                component: Weather
            },



    ]
})
