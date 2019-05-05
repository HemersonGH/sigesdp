<template lang="pug">
  div
    v-layout.padding(row)
      v-flex(
        xs2 sm2 offset-sm2
      )
        v-card
          v-img(
            src="https://cdn.vuetifyjs.com/images/cards/desert.jpg"
            aspect-ratio="2.75"
          )
          v-card-title( primary-title )
            div
              h3(
                class="headline mb-0"
              ) Kangaroo Valley Safari
              div {{ card_text }}
            v-card-actions
              v-btn(flat color="blue") Share
              v-btn(flat color="orange") Explore
      v-flex(
        xs2 sm2 offset-sm2
      )
        v-card
          v-img(
            src="https://cdn.vuetifyjs.com/images/cards/desert.jpg"
            aspect-ratio="2.75"
          )
          v-card-title( primary-title )
            div
              h3(
                class="headline mb-0"
              ) Kangaroo Valley Safari
              div {{ card_text }}
          v-card-actions
            v-btn(flat color="blue") Share
            v-btn(flat color="orange") Explore
</template>

<script>
export default {
  name: 'TheCard',

  data () {
    return {
      card_text: 'Lorem ipsum dolor sit amet, brute iriure accusata ne mea.'
    }
  }
}
</script>

<style scoped>
  .padding {
    padding: 20px;
  }
</style>
