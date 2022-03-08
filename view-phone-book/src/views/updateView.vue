<template>
  <h1>Update</h1>
  <router-link to="/patch/fullName">Update fullName</router-link>
  <router-link to="/patch/phone">Update phone</router-link>
  <router-link to="/patch/email">Update email</router-link>
  <router-link to="/patch/Dob">Update DateOfBirth</router-link>
  <router-view></router-view>

  <form action="" id="formUpdate">
    <label for="id"></label>
    <input type="text" id="id" v-model="id" placeholder="id" required>
    <label for="fullName"></label>
    <input type="text" id="fullName" v-model="fullName" placeholder="fullName" required>
    <label for="phone"></label>
    <input type="text" id="phone" v-model="phone" placeholder="phone" required>
    <label for="email"></label>
    <input type="text" id="email" v-model="email" placeholder="email" required>
    <label for="dateOfBirth"></label>
    <input type="date" id="dateOfBirth" v-model="dateOfBirth" placeholder="dateOfBirth" required>
    <button type="button" @click="addContact">Update contact</button>
  </form>
  <div class="info">
    <table>
      <tr v-if="data.id">
        <td>Id</td>
        <td>Full name</td>
        <td>Phone</td>
        <td>Email</td>
        <td>Date of birth</td>
      </tr>
      <tr>
        <td>{{data.id}}</td>
        <td>{{data.fullName}}</td>
        <td>{{data.phone}}</td>
        <td>{{data.email}}</td>
        <td>{{data.dateOfBirth}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
const API = "http://localhost:8080/contact/";

  export default {
    data() {
      return {
        id: null,
        fullName: '',
        phone: '',
        email: '',
        dateOfBirth: null,
        data: []
      }
    },
    methods: {
      async addContact() {
        const apiUrl = `${API}${this.id}`;
        const options = {
          method: "PUT",
          mode: "cors",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            fullName: this.fullName,
            phone: this.phone,
            email: this.email,
            dateOfBirth: this.dateOfBirth
          })
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
#formUpdate {
  margin-block-start: 30px;
}
.info {
  margin-block-start: 50px;
}
</style>