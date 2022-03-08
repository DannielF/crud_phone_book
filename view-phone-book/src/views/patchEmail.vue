<template>
  <h1>Update email</h1>
  <router-link to="/patch/fullName">Update fullName</router-link>
  <router-link to="/patch/phone">Update phone</router-link>
  <router-link to="/patch/Dob">Update DateOfBirth</router-link>
  <router-view></router-view>

  <form action="" id="formUpdate">
    <label for="id"></label>
    <input type="text" id="id" v-model="id" placeholder="id">
    <label for="email"></label>
    <input type="text" id="email" v-model="email" placeholder="email" required>
    <button type="button" @click="updateEmail">Update email</button>
  </form>
</template>

<script>
const API = "http://localhost:8080/contact/email/";

  export default {
    data() {
      return {
        id: null,
        email: '',
        data: []
      }
    },
    methods: {
      async updateEmail() {
        const apiUrl = `${API}${this.id}`;
        const options = {
          method: "PATCH",
          mode: "cors",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            email: this.email
          }),
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

<style></style>