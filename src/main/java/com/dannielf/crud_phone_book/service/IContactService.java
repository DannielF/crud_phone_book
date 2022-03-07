package com.dannielf.crud_phone_book.service;

import com.dannielf.crud_phone_book.domain.Contact;

import java.util.List;
import java.util.Optional;

/**
 * Interface for the mandatory services
 *
 * EJ:
 * public class contact implements IContactService
 *
 * @version 1.0.0
 * @author Daniel Granados
 * @since 1.0.0
 */
public interface IContactService {

    /**
     * Show all the contacts
     * @return List of contacts
     */
    public List<Contact> list();

    /**
     * Save a new contact
     * @param contact Object
     * @return contact
     */
    public Contact save(Contact contact);

    /**
     * Update a contact
     * @param id Long
     * @param contact Object
     * @return contact
     */
    public Contact update(Long id, Contact contact);

    /**
     * Delete a contact
     * @param contact Object
     */
    public void delete(Contact contact);

    /**
     * Find one contact
     * @param contact Object
     * @return contact
     */
    public Optional<Contact> findContact(Contact contact);
}
