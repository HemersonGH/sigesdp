<template lang="pug">
        v-tooltip(
            :bottom='true'
        )
            template(
                v-slot:activator='{ on }'
            )
                v-btn.styleButton(
                    flat,
                    v-if='true',
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
  name: 'ButtonTheHeader',
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
        color: #ffffff;
        font-weight: bold;
    }

    .v-tooltip__content {
        width: max-content;
    }
</style>
