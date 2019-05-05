<template lang="pug">
  v-app
    Toolbar
    SideMenu
    Content
</template>

<script>
import Toolbar from '@/components/shared/Toolbar.vue'
import SideMenu from '@/components/shared/SideMenu.vue'
import Content from '@/components/shared/Content.vue'

export default {
  name: 'App',

  components: {
    Toolbar,
    SideMenu,
    Content
  }
}
</script>

<style lang="scss">
@import '@/styles/index.scss';

.v-datatable thead th.column.sortable i {
  vertical-align: unset;
}
</style>
