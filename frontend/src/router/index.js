import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '../views/Products.vue'
import Home from '../views/Home.vue'
import Contactus from '../views/Contactus.vue'
import Aboutus from '../views/Aboutus.vue'
import Cart from '../views/Cart.vue'

Vue.use(VueRouter)

const routes = [{
        path: '/home',
        name: 'home',
        component: Home,
        meta: {
            title: 'Home'
        }
    },
    {
        path: '/products',
        name: 'products',
        component: Products
    },
    {
        path: '/aboutus',
        name: 'aboutus',
        component: Aboutus
    },
    {
        path: '/contactus',
        name: 'contactus',
        component: Contactus
    },
    {
        path: '/cart',
        name: 'cart',
        component: Cart
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router