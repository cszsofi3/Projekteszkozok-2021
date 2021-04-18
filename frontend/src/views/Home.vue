<template>
  <v-app id="inspire">
    <v-carousel
      v-model="carousel"
      cycle
      height="400"
      hide-delimiter-background
      show-arrows-on-hover
    >
      <v-carousel-item v-for="(item, i) in items" :key="i" :src="item.src">
        <v-row class="fill-height" align="center" justify="center">
          <div class="display-3">{{ item.text }}</div>
        </v-row>
      </v-carousel-item>
    </v-carousel>
    <v-container>
      <v-layout column>
        <v-flex class="display-2 text-xs-center my-5">
          Üdvözlünk az Ételrendelő Webalkalmazás honlapján!</v-flex
        >
        <v-flex>
          <div class="headline mt-3">Hogy miért éri meg nálunk rendelned?</div>
          <p class="subheading mt-3">Nézd meg miért!</p>
        </v-flex>
        <v-btn class="home-btn" color="primary" rounded @click="redirectToAboutUs()">
          Ételeink
        </v-btn>
        <v-divider></v-divider>
        <v-flex>
          <div class="headline mt-3">Partnereink</div>
          <p class="subheading mt-3">
            - McDolands<br />
            - KDC<br />
            - BurgerQueen<br />
            - CometBucks<br />
            - PodThai<br />
            ...és sok más!<br />
          </p>
        </v-flex>
        <v-btn class="home-btn" color="primary" rounded @click="redirectToContact()">
          Kapcsolat
        </v-btn>
        <v-divider></v-divider>
        <v-flex>
          <div class="headline mt-3">Ingyenes házhozszállítás!</div>
          <p class="subheading mt-3">
            1000 Ft értékű rendelés felett a szállításért nem kell fizess!<br />
          </p>
        </v-flex>
        <v-btn class="home-btn" color="primary" rounded @click="redirectToAboutUs()">
          Rólunk
        </v-btn>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
export default {
  name: "Home",
  data: () => ({
    carousel: true,
    items: [
      {
        id: 1,
        src: require("../assets/food1.jpg"),
        text: "Élvezd az ételeket",
      },
      {
        id: 2,
        src: require("../assets/food2.jpg"),
        text: "Ízleld meg a világot",
      },
      {
        id: 3,
        src: require("../assets/hamburger1.jpg"),
        text: "Zamatos hamburgerek",
      },
      {
        id: 4,
        src: require("../assets/hamburger2.jpg"),
        text: "Találd meg a kedvenc éttermed",
      },
      {
        id: 5,
        src: require("../assets/pancakes.jpg"),
        text: "A nap bármelyik pontjában",
      },
    ],
  }),
  methods: {
    redirectToFood() {
      this.$router.replace({ name: "products" });
    },
    redirectToContact() {
      this.$router.replace({ name: "contactus" });
    },
    redirectToAboutUs() {
      this.$router.replace({ name: "aboutus" });
    },
  },
};
</script>

<style>
.home-btn{
  width: 120px;
  margin-bottom: 10px;
}
</style>