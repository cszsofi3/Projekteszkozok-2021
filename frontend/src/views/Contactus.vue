<template>
  <v-app id="inspire">
    <v-container>
      <v-layout column>
        <v-flex class="display-2 text-xs-center my-5">Kapcsolat</v-flex>
        <v-flex>
          <div class="headline mt-3">KARRIER</div>
          <p class="subheading mt-3">
            Jelenleg nincs nyitott pozicíónk. Nézz vissza később!
          </p>
        </v-flex>
        <v-divider></v-divider>
        <v-flex>
          <div class="headline mt-3">SAJTÓ MEGKERESÉSEK</div>
          <p class="subheading mt-3">
            Cikket írnál rólunk, interjút szeretnél vagy rendezvényre invitálnál
            bennünket?<br />
            Fordulj bizalommal hozzánk a sajto@etelrendelowebalkalmazas.hu
            e-mail címen keresztül.
          </p>
        </v-flex>
        <v-divider></v-divider>
        <v-flex>
          <div class="headline mt-3">MARKETING EGYÜTTMŰKÖDÉS</div>
          <p class="subheading mt-3">
            Marketing együttműködésben gondolkodsz, érdekel milyen lehetőségek
            vannak?<br />
            Keress minket a kapcsolat@etelrendelowebalkalmazas.hu e-mail címen.
          </p>
        </v-flex>
        <v-divider></v-divider>
        <v-flex>
          <div class="headline mt-3">Kérdésed lenne?</div>
          <p class="subheading mt-3">Írj nekünk bátran!</p>
        </v-flex>
          <v-textarea
          class="txt-area"
            outlined
            label="Ide írd kérdésed/javaslatod"
            v-model="text"
          ></v-textarea>
          <v-btn class="home-btn" color="red" dark rounded @click="sendQuestion()">
          Send
        </v-btn>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
export default {
  name: "Contactus",
  data: () => ({
      text: ""
  }),
  methods:{
      sendQuestion(){
          this.text = ""
          //TODO: elküldeni backend
      }
  }
};
</script>

<style>
.txt-area{
    width: 850px;
}
</style>