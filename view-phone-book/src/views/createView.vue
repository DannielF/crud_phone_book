<template>
  <h1>Welcome, let's add a new contact</h1>
  <form action="">
    <label for="fullName"></label>
    <input type="text" id="fullName" v-model="fullName" placeholder="fullName" required>
    <label for="phone"></label>
    <input type="text" id="phone" v-model="phone" placeholder="phone" required>
    <label for="email"></label>
    <input type="text" id="email" v-model="email" placeholder="email" required>
    <label for="dateOfBirth"></label>
    <input type="date" id="dateOfBirth" v-model="dateOfBirth" placeholder="dateOfBirth" required>
    <button type="button" @click="addContact">Add contact</button>
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
          <td>{{cnt.id}}</td>
          <td>{{cnt.fullName}}</td>
          <td>{{cnt.phone}}</td>
          <td>{{cnt.email}}</td>
          <td>{{cnt.dateOfBirth}}</td>
        </tr>
      </template>
    </table>
  </div>
</template>

<script>
const API = "http://localhost:8080/contact";

  export default {
    data() {
      return {
        fullName: this.fullName,
        phone: this.phone,
        email: this.email,
        dateOfBirth: this.dateOfBirth,
        data: []
      }
    },
    methods: {
      async addContact() {
        const apiUrl = `${API}`;
        const options = {
          method: "POST",
          mode: "cors",
          headers: {
            "Content-Type": "application/json"
          },
          credentials: "same-origin",
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
  form {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  label {
    margin-bottom: 10px;
  }
  input {
    margin-bottom: 10px;
    width: 300px;
  }
  button {
    margin-top: 10px;
    width: 200px;
    font-weight: bold;
  }
</style>