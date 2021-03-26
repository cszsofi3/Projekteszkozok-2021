<template>
  <button :class="btnColor" >
    <slot></slot>
    <img v-if="cartIcon" src="../images/cart.svg" alt="Cart Icon">
  </button>
</template>

<script>
export default {
  props: ['btnColor', 'cartIcon'],
};
</script>

<style scoped>
  .btn{
      color: #fff;
  }
  .btn-small {
    padding: .5em 2em;
  }

  .btn-medium {
    padding: .7em 4.5em;
  }

  .btn-large {
    padding: .7em 5em;
  }

  .btn img {
    max-width: 20px;
    margin-left: .5em;
  }

</style>
