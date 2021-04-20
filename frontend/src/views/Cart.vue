<template>
  <v-app id="inspire">
    <!-- Food in cart -->
    <v-container fluid>
      <v-card width="800px" class="mx-auto" :elevation="5">
        <v-card-title> My Cart </v-card-title>
        <v-divider></v-divider>
        <v-list three-line>
          <template v-for="item in test_datas">
            <v-list-item :key="item.id">
              <v-list-item-avatar>
                <v-img :src="item.img"></v-img>
              </v-list-item-avatar>
              <v-list-item-content>
                <v-list-item-title v-html="item.name"></v-list-item-title>
                <v-list-item-subtitle
                  v-text="'Toppings: '"
                ></v-list-item-subtitle>
                <v-list-item-subtitle
                  v-if="item.garlic == true"
                  v-text="'- Garlic '"
                ></v-list-item-subtitle>
                <v-list-item-subtitle
                  v-if="item.bacon == true"
                  v-text="'- Bacon '"
                ></v-list-item-subtitle>
                <v-list-item-subtitle
                  v-if="item.cheese == true"
                  v-text="'- Cheese '"
                ></v-list-item-subtitle>
                <v-list-item-subtitle
                  class="text--primary"
                  v-text="'Total price: ' + item.price + '$'"
                ></v-list-item-subtitle>
              </v-list-item-content>
              <v-list-item-action>
                <v-btn
                  color="red"
                  text
                  rounded
                  class="my-2"
                  @click="remove(item.id)"
                >
                  <v-icon>mdi-delete</v-icon>
                </v-btn>
                <v-btn
                  color="blue"
                  text
                  rounded
                  class="my-2"
                  @click="edit(item)"
                  >Edit
                  <v-icon small>mdi-pencil</v-icon>
                </v-btn>
              </v-list-item-action>
            </v-list-item>
          </template>
        </v-list>
        <v-row align="center">
          <v-col cols="3">
            <v-text-field
              v-model="coupon"
              label="Kupon kód"
              placeholder="Írja be a kupon kódját..."
              :hint="couponHint"
              persistent-hint
              class="tf"
            ></v-text-field>
          </v-col>
          <v-col cols="9">
            <v-btn color="red" dark rounded @click="checkCoupon()">
              Enter
            </v-btn>
          </v-col>
        </v-row>
        <v-card-actions>
          <template> Total price: {{ price }}$ </template>
          <v-spacer></v-spacer>
          <v-btn color="red" dark rounded @click="order()"> Order food </v-btn>
        </v-card-actions>
      </v-card>
    </v-container>
    <!-- Dialog -->
    <v-dialog v-model="editDialog" width="200" persistent>
      <v-card>
        <v-card-actions>
          <v-btn
            color="light-blue white--text"
            text
            @click="closeEditDialog()"
            rounded
            outlined
            >Close
          </v-btn>
          <v-btn
            color="light-blue white--text"
            text
            @click="save()"
            rounded
            outlined
            >Save</v-btn
          >
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-app>
</template>

<script>
//import { mapGetters, mapActions } from 'vuex';
export default {
  name: "Cart",
  props: ["app"],
  data: () => ({
    price: 0,
    editDialog: false,
    coupon: "",
    usedCoupon: false,
    goodCoupon:false,
    couponHint:"",
    coupons: ["ABCDEFG", "1234567", "HESOYAM"],
    test_datas: [
      {
        img: "",
        price: 20,
        description: "Tasty pizza",
        id: 0,
        name: "Pizza",
        bacon: true,
        cheese: "",
        garlic: true,
      },
      {
        img: "",
        price: 30,
        description: "Nice hamburger",
        id: 1,
        name: "Hamburger",
        bacon: true,
        cheese: "",
        garlic: "",
      },
      {
        img: "",
        price: 200,
        description: "Nice steak",
        id: 2,
        name: "Steak",
        bacon: true,
        cheese: true,
        garlic: true,
      },
      {
        img: "",
        price: 50,
        description: "Apple",
        id: 3,
        name: "Apple",
        bacon: "",
        cheese: true,
        garlic: "",
      },
    ],
  }),
  /*computed: {
    ...mapGetters([
      'getProductsInCart',
    ]),
  },*/
  mounted() {
    //TODO: this.getProducts()
    this.totalPrice();
  },
  watch: {
    totalPrice() {
      this.totalPrice();
    },
  },
  methods: {
    /*...mapActions([
      'removeProduct',
    ]),*/
    hasProduct() {
      return false; //this.getProductsInCart.length > 0;
    },
    totalPrice() {
      /*return this.getProductsInCart.reduce(
        (current, next) => current + next.price,
        0
      );*/
      if(this.test_datas.length < 1){
        this.price = 0;
        return;
      }
      let total = 0;
      for (let i = 0; i < this.test_datas.length; i++) {
        total += this.test_datas[i].price;
      }
      this.price = total;
    },
    remove(index) {
      if(this.test_datas.length < 2){
        this.test_datas.pop();
        return;
      }
      this.test_datas.splice(index,1);
      // itt hívd meg újra a lekérdezést, hogy frissüljön a lista, és emit-eld az App-nak, hogy hány elem lett remove-olva ( count * -1)

      this.totalPrice();
    },
    order() {
      //TODO
    },
    edit(item) {
      //TODO
      this.editDialog = true;
    },
    closeEditDialog() {
      this.editDialog = false;
    },
    save() {},
    checkCoupon() {
      for (let i = 0; i < this.coupons.length; i++) {
        if (this.coupon == this.coupons[i]) {
          this.goodCoupon = true;
        }
      }
      if(!this.usedCoupon){
        if(this.goodCoupon){
          this.usedCoupon = true;
          this.price = this.price*0.9;
          this.couponHint = "Kupon sikeresen felhasználva! -10% a végösszegből.";
        }else{
          this.couponHint = "Rossz kupon!";
        }
      }else{
        this.couponHint = "Ez már egy felhasznált/lejárt kupon!";
      }
    },
  },
};
</script>

<style scoped>
.tf {
  max-width: 200px;
  padding-left: 10px;
}
.checkout-box {
  width: 100%;
  max-width: 900px;
  display: flex;
  flex-direction: column;
  margin: 50px auto;
  box-sizing: border-box;
  padding: 1em;
}
.checkout-list {
  padding: 0;
}
.checkout-product {
  display: grid;
  grid-template-columns: 1fr 3fr 2fr 0.5fr;
  background-color: #fff;
  box-shadow: 0px 0px 10px rgba(73, 74, 78, 0.1);
  border-radius: 5px;
  list-style: none;
  box-sizing: border-box;
  padding: 0.8em;
  margin: 1em 0;
}
.checkout-product * {
  place-self: center;
}
.product-image {
  grid-column: 1/2;
  width: 50%;
}
.product-name {
  box-sizing: border-box;
}
.product-price {
  font-size: 1.2em;
  font-weight: bold;
}
.product-remove {
  width: 25px;
  height: 25px;
  border-radius: 50%;
  border: 0;
  background-color: #e0e0e0;
  color: #fff;
  cursor: pointer;
}
.total {
  font-size: 2em;
  font-weight: bold;
  align-self: flex-end;
}
.checkout-message {
  font-size: 1.5em;
}
.fade-enter-active,
.fade-leave-active {
  transition: all 0.5s;
}
.fade-enter,
.fade-leave-to {
  transform: translateX(-40px);
  opacity: 0;
}
</style>