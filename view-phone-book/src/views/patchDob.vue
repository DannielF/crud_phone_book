<template>
  <h1>Update Date of birth</h1>
  <router-link to="/patch/fullName">Update fullName</router-link>
  <router-link to="/patch/phone">Update phone</router-link>
  <router-link to="/patch/email">Update email</router-link>
  <router-view></router-view>

  <form action="" id="formUpdate">
    <label for="id"></label>
    <input type="text" id="id" v-model="id" placeholder="id">
    <label for="dob"></label>
    <input type="date" id="dob" v-model="dob" placeholder="dob" required>
    <button type="button" @click="updateDob">Update dateOfBirth</button>
  </form>
</template>

<script>
const API = "http://localhost:8080/contact/dob/";

  export default {
    data() {
      return {
        id: null,
        dob: null,
        data: []
      }
    },
    methods: {
      async updateDob() {
        const apiUrl = `${API}${this.id}`;
        const options = {
          method: "PATCH",
          mode: "cors",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            dob: this.dob
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