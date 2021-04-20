<template>
  <v-app id="inspire">
    <!-- Food -->
    <v-container >
      <v-row>
          <v-col sm="4" v-for="product in events" :key="product.id">
            <v-hover v-slot:default="{ hover }">
              <v-card
                class="mx-auto mt-9"
                color="grey lighten-4"
                max-width="300"
                :elevation="hover ? 15 : 2"
              >
                <v-img :aspect-ratio="3/2" :src="product.img">
                  <v-expand-transition>
                    <div
                      v-if="hover"
                      class="d-flex transition-fast-in-fast-out blue darken-2 v-card--reveal display-3 white--text"
                      style="height: 100%;"
                    >${{product.price}}</div>
                  </v-expand-transition>
                </v-img>
                <v-card-text class="pt-6" style="position: relative;">
                  <v-btn
                    absolute
                    color="blue"
                    class="white--text"
                    fab
                    large
                    right
                    top
                    @click="toCart(product)"
                  >
                    <v-icon>mdi-cart</v-icon>
                  </v-btn>
                  <div class="font-weight-light title mb-2">Only {{product.quantity}} left!</div>
                  <h4 class="display-1 font-weight-light blue--text mb-2">{{product.name}}</h4>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn
                    color="light-blue white--text"
                    @click="showProduct(product)"
                    outlined
                    rounded
                  >About the product</v-btn>
                </v-card-actions>
              </v-card>
            </v-hover>
          </v-col>
        </v-row>
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

import { axios } from "@/main";

export default {
  name: "Products",
  props: ["app"],
  data: () => ({
    events: [],
    product_info: false,
    num: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
    count: 1,
    total:0,
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
      count:0,
    },
    cart: [],
  }),
  mounted(){
    //this.toFoodList(this.get());
    this.toCart();    //csak tesztelés miatt van
    //this.get();
  },
  methods: {
    toCart() {
      this.product.cheese = this.cheeseBox;
      this.product.garlic = this.garlicBox;
      this.product.bacon = this.baconBox;
      this.product.count = this.count;

      this.total += this.count;
      this.$emit("cartNum", this.total);

      this.cart.push(this.product);
      this.get();
      this.closeProductInfo();
    },
    showProduct(p) {
      this.product.quantity = p.quantity;
      this.product.price = p.price;
      this.product.description = p.description;
      this.product.id = p.id;
      this.product.name = p.name;
      this.product.count = 1;
      this.product_info = true;
    },
    closeProductInfo() {
      //this.product.garlic = false;
      //this.product.bacon = false;
      //this.product.cheese = false;
      this.cheeseBox = false;
      this.baconBox = false;
      this.garlicBox = false;

      this.product.count = 1;
      this.product_info = false;
    },
    get() {
      axios({
        method: "get",
        url: "http://localhost:8080/food/all",
      })
        .then((response) => {
          console.log("sikeres get");
          this.toFoodList(response.data);
        })
        .catch(function (response) {
          console.log("catch : " + response);
        });
    },
    async send(productList) {
      /*await axios({
        method: "post",
        url: "/Orders",
        data: productList,
      }).then(function (response) {
        console.log("success : " + response);
      });*/
    },
    toFoodList(responseData) {
      var listFood = [];
      console.log(responseData);
      responseData.forEach(element => {
        var product = { };
        product.id = element.id;
        product.description = element.name;
        product.name = element.type;
        product.price = element.price;
        product.img = "";
        product.count = 1;
        product.bacon = "";
        product.cheese = "";
        product.garlic = "";
        listFood.push(product);
      });
      this.events = listFood;
    },
  },
};
</script>

<style>
</style>