import { createRouter, createWebHistory } from 'vue-router';

import homeView from '../views/homeView.vue';
import getAll from '../views/getAll.vue'
import getOne from '../views/getOne.vue'
import create from '../views/createView.vue'
import update from '../views/updateView.vue'
import deleteOne from '../views/deleteView.vue'
import fullName from '../views/patchFullName.vue'
import phone from '../views/patchPhone.vue'
import email from '../views/patchEmail.vue'
import DateOfBirth from '../views/patchDob.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: homeView,
  },
  {
    path: '/contacts',
    name: 'getAll',
    component: getAll,
  },
  {
    path: '/contact',
    name: 'getOne',
    component: getOne,
  },
  {
    path: '/create',
    name: 'create',
    component: create,
  },
  {
    path: '/update',
    name: 'update',
    component: update,
  },
  {
    path: '/delete',
    name: 'delete',
    component: deleteOne
  },
  {
    path: '/patch/fullName',
    name: 'patchFullName',
    component: fullName,
  },
  {
    path: '/patch/phone',
    name: 'patchPhone',
    component: phone,
  },
  {
    path: '/patch/email',
    name: 'patchEmail',
    component: email,
  },
  {
    path: '/patch/Dob',
    name: 'patchDob',
    component: DateOfBirth,
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes: routes,
});

export default router;