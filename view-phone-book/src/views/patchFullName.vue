<template>
  <h1>Update fullName</h1>
  <router-link to="/patch/phone">Update phone</router-link>
  <router-link to="/patch/email">Update email</router-link>
  <router-link to="/patch/Dob">Update DateOfBirth</router-link>
  <router-view></router-view>

  <form action="" id="formUpdate">
    <label for="id"></label>
    <input type="text" id="id" v-model="id" placeholder="id">
    <label for="fullName"></label>
    <input type="text" id="fullName" v-model="fullName" placeholder="fullName" required>
    <button type="button" @click="updateFullName">Update contact</button>
  </form>
  <div class="info">
    <table>
      <tr v-if="data.data">
        <td>Id</td>
        <td>Full name</td>
        <td>Phone</td>
        <td>Email</td>
        <td>Date of birth</td>
      </tr>
      <template v-for="cnt in data">
        <tr>
          <td>{{cnt}}</td>
        </tr>
      </template>
    </table>
  </div>
</template>

<script>
const API = "http://localhost:8080/contact/fullName/";

  export default {
    data() {
      return {
        id: null,
        fullName: '',
        data: []
      }
    },
    methods: {
      async updateFullName() {
        const apiUrl = `${API}${this.id}`;
        const options = {
          method: "PATCH",
          mode: "cors",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            fullName: this.fullName
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