<template lang="pug">
    v-tooltip(
        :bottom='true'
    )
        template(
            v-slot:activator='{ on }'
        )
            v-btn.styleButton(
                v-if='true',
                color='blue',
                class='white--text',
                v-on='on'
            ) {{ labelBtn }} &nbsp
                v-icon(
                    v-if='true'
                ) input
                v-icon(
                    v-else
                ) home
        span(
            v-if='true'
        ) Acessar o SiGESDP
        span(
            v-else
        ) Sair do sistema
</template>

<script>
export default {
  name: 'BotaoTheHeader',
  props: {
    labelBtn: {
      type: String,
      required: true
    }
  }
}
</script>

<style scoped>
    .styleButton {
        font-weight: bold;
    }
</style>
