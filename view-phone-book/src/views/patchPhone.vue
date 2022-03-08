<template>
  <h1>Update phone</h1>
  <router-link to="/patch/fullName">Update fullName</router-link>
  <router-link to="/patch/email">Update email</router-link>
  <router-link to="/patch/Dob">Update DateOfBirth</router-link>
  <router-view></router-view>

  <form action="" id="formUpdate">
    <label for="id"></label>
    <input type="text" id="id" v-model="id" placeholder="id">
    <label for="phone"></label>
    <input type="text" id="phone" v-model="phone" placeholder="phone" required>
    <button type="button" @click="updatePhone">Update phone</button>
  </form>
</template>

<script>
const API = "http://localhost:8080/contact/phone/";

  export default {
    data() {
      return {
        id: null,
        phone: '',
        data: []
      }
    },
    methods: {
      async updatePhone() {
        const apiUrl = `${API}${this.id}`;
        const options = {
          method: "PATCH",
          mode: "cors",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            phone: this.phone
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