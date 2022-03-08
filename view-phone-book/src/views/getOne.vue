<template>
  <h1>Search one contact at time</h1>
  <div>
    <input type="text" id="id" v-model="id" placeholder="Enter id">
    {{' '}}
    <button @click="getOne">Search</button>
  </div>
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
  .info{
    margin-block-start: 10px;
    padding-inline: 30px
  }
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