<template>
  <v-app id="inspire">
    <v-carousel
      v-model="carousel"
      cycle
      height="400"
      hide-delimiter-background
      show-arrows-on-hover
    >
      <v-carousel-item v-for="(color, i) in colors" :key="color">
        <v-sheet :color="color" height="100%" tile>
          <v-row class="fill-height" align="center" justify="center">
            <div class="display-3">Slide {{ i + 1 }}</div>
          </v-row>
        </v-sheet>
      </v-carousel-item>
    </v-carousel>
    <v-container>
      <v-layout column>
        <v-flex class="display-2 text-xs-center my-5">
          Üdvözlünk az Ételrendelő Webalkalmazás honlapján!</v-flex
        >
        <v-flex>
          <div class="headline mt-3">Hogy miért éri meg nálunk rendelned?</div>
          <p class="subheading mt-3">
            Nézd meg miért!
          </p>
        </v-flex>
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
        <v-divider></v-divider>
        <v-flex>
          <div class="headline mt-3">Ingyenes házhozszállítás!</div>
          <p class="subheading mt-3">
            1000 Ft értékű rendelés felett a szállításért nem kell fizess!<br />
          </p>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
export default {
  name: "Home",
  data: () => ({
    carousel: true,
    colors: ["primary", "secondary", "yellow darken-2", "red", "orange"],
    //Ide egy objektum tömb kell amiből dolgozik a carousel: kép, dia neve
  }),
};

</script>

<style>
</style>