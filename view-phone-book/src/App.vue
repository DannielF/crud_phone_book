<script setup lang="js">
</script>

<template>
  <router-link to="/">Home</router-link>
  <router-link to="/contacts">Contacts</router-link>
  <router-link to="/contact">Contact</router-link>
  <router-link to="/create">Create</router-link>
  <router-link to="/update">Update</router-link>
  <router-link to="/delete">Delete</router-link>
  <router-view></router-view>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
a {
  margin: 0 5px;
}
</style>
