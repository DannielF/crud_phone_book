<template>
  <h1>Here you will see all your contacts</h1>
  <button @click="getContacts">Show contacts</button>
  <div class="info">
    <table>
      <tr v-if="data.data">
        <td>Id</td>
        <td>Full name</td>
        <td>Phone</td>
        <td>Email</td>
        <td>Date of birth</td>
      </tr>
      <template v-for="cnt in data.data">
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

<script lang="js">

  const API = "http://localhost:8080/contact";
 
  export default {
    data() {
      return {
        data: []
      }
    },
    methods: {
      async getContacts() {
        const apiUrl = API;
        const options = {
          method: "GET",
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
  table {
    border-collapse: collapse;
    width: 100%;
  }
  tr {
    border-bottom: 1px solid #ddd;
  }
  td {
    padding: 8px;
  }
</style>