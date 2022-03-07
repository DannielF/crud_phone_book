package com.dannielf.crud_phone_book.controller;

import com.dannielf.crud_phone_book.domain.Contact;
import com.dannielf.crud_phone_book.service.ContactService;
import com.dannielf.crud_phone_book.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


/**
 *
 */
@Slf4j
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    private Response response = new Response();

    @GetMapping(path = "/")
    public Map<String, String> index() {
        var answer = new HashMap<String, String>();
        answer.put("message:", "Do it, but not try");
        return answer;
    }

    @GetMapping("/contact/{id}")
    public Response getOne(Contact contact) {

        try {
            log.info("Contact found: {}", contact);
            response.data = contactService.findContact(contact);

        } catch (Exception e) {
            response.error = true;
            response.message = e.getMessage();
            response.status = "ERROR 404, NOT FOUND";
        }
        return response;
    }

    @GetMapping(path = "/contact")
    public Response getAll() {

        try {
            response.data = contactService.list();

        } catch (Exception e) {
            response.error = true;
            response.message = e.getMessage();
            response.status = "ERROR 404, NOT FOUND";
        }
        return response;
    }

    @PostMapping(path = "/contact")
    public ResponseEntity<Response> create(Contact contact) {
        response.data = contact;

        try {
            log.info("Contact to create: {}", contact);
            contactService.save(contact);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            response.status = e.getCause().toString();
            response.error = true;

            if (Pattern.compile("(contact.cnt_phone_name)").matcher(e.getMessage()).find()) {
                response.message = "Duplicate contact";
                return new ResponseEntity<>(response, HttpStatus.CONFLICT);
            } else {
                response.message = e.getMessage();
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> delete(Contact contact) {

        try {
            log.info("Contact to delete: {}", contact);
            contactService.delete(contact);
            return new ResponseEntity<>(contact , HttpStatus.OK);

        } catch (Exception e) {
            response.status = e.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> update(Contact contact, @PathVariable("id") Long id) {

        try {
            log.info("Contact to update: {}", contact);
            contactService.update(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);

        } catch (Exception e) {
            response.status = e.getCause().toString();
            response.error = true;
            response.message = "Duplicate entry";
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PatchMapping(path = "/contact/fullName/{id}")
    public ResponseEntity<Contact> updateFullName(Contact contact, @PathVariable("id") Long id) {

        try {
            log.info("Contact, new fullName: {}", contact);
            contactService.updateFullName(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);

        } catch (Exception e) {
            response.status = e.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PatchMapping(path = "/contact/phone/{id}")
    public ResponseEntity<Contact> updatePhone(Contact contact, @PathVariable("id") Long id) {

        try {
            log.info("Contact, new phone: {}", contact);
            contactService.updatePhone(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);

        } catch (Exception e) {
            response.status = e.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PatchMapping(path = "/contact/email/{id}")
    public ResponseEntity<Contact> updateEmail(Contact contact, @PathVariable("id") Long id) {

        try {
            log.info("Contact, new email: {}", contact);
            contactService.updateEmail(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);

        } catch (Exception e) {
            response.status = e.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PatchMapping("/contact/dob/{id}")
    public ResponseEntity<Contact> updateDob(Contact contact, @PathVariable("id") Long id) {

        try {
            log.info("Contact, new date of birth: {}", contact);
            contactService.updateDob(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);

        } catch (Exception e) {
            response.status = e.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PatchMapping("/contact/updAt/{id}")
    public ResponseEntity<Contact> updateAt(Contact contact, @PathVariable("id") Long id) {

        try {
            log.info("Contact, has been updated: {}", contact);
            contactService.updateAt(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);

        } catch (Exception e) {
            response.status = e.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PatchMapping("/contact/delAt/{id}")
    public ResponseEntity<Contact> deleteAt(Contact contact, @PathVariable("id") Long id) {

        try {
            log.info("Contact, logical delete: {}", contact);
            contactService.deleteAt(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);

        } catch (Exception e) {
            response.status = e.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
