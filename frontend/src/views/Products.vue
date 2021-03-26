<template>
  <v-app id="inspire">
    <!-- Food -->
    <v-container>
      <v-hover v-slot:default="{ hover }">
        <v-card
          class="mx-auto mt-9"
          color="grey lighten-4"
          max-width="300"
          :elevation="hover ? 15 : 2"
        >
          <v-img :aspect-ratio="3 / 2">
            <v-expand-transition>
              <div
                v-if="hover"
                class="d-flex transition-fast-in-fast-out blue darken-2 v-card--reveal display-3 white--text"
                style="height: 100%"
              >
                ${{ product.price }}
              </div>
            </v-expand-transition>
          </v-img>
          <v-card-text class="pt-6" style="position: relative">
            <h4 class="display-1 font-weight-light blue--text mb-2">
              {{ product.name }}
            </h4>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="light-blue white--text"
              @click="showProduct(product)"
              outlined
              rounded
              >Edit</v-btn
            >
          </v-card-actions>
        </v-card>
      </v-hover>
    </v-container>
    <!-- Food info -->
    <v-dialog v-model="product_info" width="700" persistent>
      <v-card>
        <v-card-actions>
          <v-card-title>{{ product.name }}</v-card-title>
        </v-card-actions>
        <v-container fluid>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title
                >Price of the product: ${{ product.price }}</v-list-item-title
              >
            </v-list-item-content>
          </v-list-item>
          <v-list-item width="80px">
            <v-list-item-content>
              <v-list-item-title
                >Desricption: {{ product.description }}.</v-list-item-title
              >
            </v-list-item-content>
          </v-list-item>
          <v-list-item width="80px">
            <v-list-item-content>
              <v-list-item-title
                ><v-checkbox v-model="cheeseBox">
                  <template v-slot:label> <div>Cheese</div></template>
                </v-checkbox>
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item width="80px">
            <v-list-item-content>
              <v-list-item-title
                ><v-checkbox v-model="garlicBox">
                  <template v-slot:label> <div>Garlic</div></template>
                </v-checkbox></v-list-item-title
              >
            </v-list-item-content>
          </v-list-item>
          <v-list-item width="80px">
            <v-list-item-content>
              <v-list-item-title
                ><v-checkbox v-model="baconBox">
                  <template v-slot:label> <div>Bacon</div></template>
                </v-checkbox></v-list-item-title
              >
            </v-list-item-content>
          </v-list-item>
        </v-container>
        <v-card-actions>
          <v-spacer></v-spacer>
          <div class="counter">
            <v-select v-model="count" :items="num"></v-select>
          </div>
          <v-btn
            color="light-blue white--text"
            text
            @click="closeProductInfo()"
            rounded
            outlined
            >Close
          </v-btn>
          <v-btn
            color="light-blue white--text"
            text
            @click="toCart(product)"
            rounded
            outlined
            >Add to cart</v-btn
          >
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-app>
</template>

<script>
import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
 
Vue.use(VueAxios, axios)

export default {
  name: "Products",
  data: () => ({
    events: [],
    product_info: false,
    num: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
    count: 0,
    cheeseBox: false,
    garlicBox: false,
    baconBox: false,
    product: {
      img: "",
      price: 20,
      description: "Tasty pizza",
      id: 1,
      name: "Pizza",
      bacon: "",
      cheese: "",
      garlic: "",
    },
    cart: [],
  }),
  methods: {
    toCart(p) {
      console.log(p);
      //let total = p.price * this.count;
      this.product.cheese = this.cheeseBox;
      this.product.garlic = this.garlicBox;
      this.product.bacon = this.baconBox;
      // this.$emit("newnum", this.count);
      // this.$emit("price", total);
      // this.$emit("products", p, this.count);
      this.count = 1;
      this.cart.push(this.product);
      console.log(this.cart);
      this.send(this.cart);
      
      this.closeProductInfo();
    },
    showProduct(p) {
      this.product.quantity = p.quantity;
      this.product.price = p.price;
      this.product.description = p.description;
      this.product.id = p.id;
      this.product.name = p.name;
      this.count = 1;
      this.product_info = true;
    },
    closeProductInfo() {
      //this.product.garlic = false;
      //this.product.bacon = false;
      //this.product.cheese = false;
      this.cheeseBox = false;
      this.baconBox = false;
      this.garlicBox = false;

      this.count = 1;
      this.product_info = false;
    },
    send(productList) {
        axios({
        method: 'post',
        url: 'https://webhook.site/f6cacaf8-dcb3-47ea-a445-eca86f34156b',
        data: productList
        }).then(function (response) {
    console.log("success : " + response);
  });
    }
  },
};
</script>

<style>
</style>