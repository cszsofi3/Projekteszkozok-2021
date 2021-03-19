<template>
  <v-app id="inspire">
    <!-- Fenti navigációs sáv -->
    <v-card class="overflow-hidden" height="100%">
      <v-app-bar color="rgb(125, 214, 255)" dark>
        <v-toolbar-title>Ételrendelő Webalkalmazás</v-toolbar-title>
        <v-spacer></v-spacer>
        <!-- Tab elemek -->
        <v-row justify="center" no-gutters>
          <nav>
            <router-link to="/home">
              <v-btn color="white" text rounded class="my-2">Főoldal</v-btn>
            </router-link>
            <router-link to="/products">
              <v-btn color="white" text rounded class="my-2">Ételek</v-btn>
            </router-link>
            <router-link to="/contactus">
            <v-btn color="white" text rounded class="my-2">Kapcsolat</v-btn>
            </router-link>
            <router-link to="/aboutus">
            <v-btn color="white" text rounded class="my-2">Rólunk</v-btn>
            </router-link>
          </nav>
        </v-row>
        <v-spacer></v-spacer>
      </v-app-bar>
    </v-card>
    <!-- Router -->
    <router-view/>
    <!-- Footer -->
    <v-footer>
      <div>
        {{ new Date().getFullYear() }} —
        <strong>Ételrendelő Webalkalmazás</strong>
      </div>
    </v-footer>
    <v-content></v-content>
  </v-app>
</template>

<script>
export default {
  name: "App",
  data: () => ({
    totalprice: 0,
    admin: false,
    products: [],
    login: false,
    form: {
      img: "",
      name: "",
      price: "",
      quantity: ""
    },
    menu: false,
    currNum: 1,
    prodnum: 0
  }),
  methods: {
  }
};
</script>
<style scoped>
nav a {
  text-decoration: none !important;
}
</style>
