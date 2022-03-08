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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


/**
 *Routes CRUD contact
 *
 * @version 1.0.0
 * @author Daniel Granados
 * @since 1.0.0
 */
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    private Response response = new Response();

    /**
     * Route Index
     * @return String
     */
    @GetMapping(path = "/")
    public Map<String, String> index() {
        var answer = new HashMap<String, String>();
        answer.put("message:", "Do it, but not try");
        return answer;
    }

    /**
     * Route Find one contact
     * @param contact Object
     * @return contact
     */
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

    /**
     * Route get all contacts
     * @return List of contacts
     */
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

    /**
     * Route to create a contact
     * @param contact Object
     * @return Entity
     */
    @CrossOrigin
    @PostMapping(path = "/contact")
    public ResponseEntity<Response> create(@RequestBody Contact contact) {
        response.data = contact;

        try {
            log.info("Contact to create: {}", contact);
            contactService.save(contact);
            return new ResponseEntity<>( response, HttpStatus.CREATED);

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

    /**
     * Route to delete a contact
     * @param contact Object
     * @return Entity
     */
    @CrossOrigin
    @DeleteMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> delete(@RequestBody Contact contact) {

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

    /**
     * Route to update a contact
     * @param contact Object
     * @param id Long
     * @return Entity
     */
    @CrossOrigin
    @PutMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> update(@RequestBody Contact contact, @PathVariable("id") Long id) {

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

    /**
     * Route to update fullName
     * @param contact Object
     * @param id Long
     * @return Entity
     */
    @CrossOrigin
    @PatchMapping(path = "/contact/fullName/{id}")
    public ResponseEntity<Contact> updateFullName(@RequestBody Contact contact, @PathVariable("id") Long id) {

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

    /**
     * Route to update phone
     * @param contact Object
     * @param id Long
     * @return Entity
     */
    @CrossOrigin
    @PatchMapping(path = "/contact/phone/{id}")
    public ResponseEntity<Contact> updatePhone(@RequestBody Contact contact, @PathVariable("id") Long id) {

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

    /**
     * Route to update email
     * @param contact Object
     * @param id Long
     * @return Entity
     */
    @CrossOrigin
    @PatchMapping(path = "/contact/email/{id}")
    public ResponseEntity<Contact> updateEmail(@RequestBody Contact contact, @PathVariable("id") Long id) {

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

    /**
     * Route to update dateOfBirth
     * @param contact Object
     * @param id long
     * @return Entity
     */
    @CrossOrigin
    @PatchMapping("/contact/dob/{id}")
    public ResponseEntity<Contact> updateDob(@RequestBody Contact contact, @PathVariable("id") Long id) {

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

    /**
     * Route to updateAt date
     * @param contact Object
     * @param id Long
     * @return Entity
     */
    @CrossOrigin
    @PatchMapping("/contact/updAt/{id}")
    public ResponseEntity<Contact> updateAt(@RequestBody Contact contact, @PathVariable("id") Long id) {

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

    /**
     * Route to deleteAt date
     * @param contact Object
     * @param id Long
     * @return Entity
     */
    @CrossOrigin
    @PatchMapping("/contact/delAt/{id}")
    public ResponseEntity<Contact> deleteAt(@RequestBody Contact contact, @PathVariable("id") Long id) {

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
