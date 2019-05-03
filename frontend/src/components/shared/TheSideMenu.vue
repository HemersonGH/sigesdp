<template lang="pug">
  div
    v-layout(
      row
    )
      v-flex(
        xs2
      )
        v-navigation-drawer.style-side(
          dark
          permanent
        )
          v-list
            v-list-tile(
              v-for="item in items"
              :key="item.title"
              @click=''
            )
              v-list-tile-action
                v-icon {{ item.icon }}
              v-list-tile-content
                v-list-tile-title {{ item.title }}
      v-flex(
        xs10
      )
        slot(name='')
</template>

<script>
export default {
  data () {
    return {
      items: [
        { title: 'Dashboard', icon: 'dashboard' },
        { title: 'Account', icon: 'account_box' },
        { title: 'Admin', icon: 'gavel' }
      ]
    }
  }
}
</script>

<style scoped>
  .style-side {
    background-color: #35a349;
    color: #ffffffff;
    font-family: Helvetica, sans-serif;
    height: 100%;
  }

  .v-tooltip__content {
    width: max-content;
  }
</style>
