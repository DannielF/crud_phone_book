<template>
  <h1>Delete one contact</h1>
  <div class="container">
    <input type="text" id="id" v-model="id" placeholder="Enter id">
    {{' '}}
    <button @click="getOne">Search</button>
  </div>
</template>

<script>
const API = "http://localhost:8080/contact/";

  export default {
    data() {
      return {
        id: this.id,
        data: []
      }
    },
    methods: {
      async getOne() {
        const apiUrl = `${API}${this.id}`;
        const options = {
          method: "DELETE",
          mode: "cors",
          headers: {
            "Content-Type": "application/json"
          },
          credentials: "same-origin"
        };

        try {
          const response = await fetch(apiUrl, options);
          this.data = await response.json();

        } catch (error) {
          console.error('Fetch error', error);
        }
      }
    }
  }
</script>

<style>
  .container{
    display: flex;
    flex-direction: column;
    align-items: center;
  }
</style>