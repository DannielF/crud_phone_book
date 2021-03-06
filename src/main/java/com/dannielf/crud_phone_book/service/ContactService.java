package com.dannielf.crud_phone_book.service;

import com.dannielf.crud_phone_book.dao.ContactDao;
import com.dannielf.crud_phone_book.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Services for Contact
 *
 * @version 1.0.0
 * @author Daniel Granados
 * @since 1.0.0
 */
@Service
public class ContactService implements IContactService{

    @Autowired
    private ContactDao contactDao;

    /**
     * Get all contacts
     * @return List of contacts
     */
    @Override
    @Transactional(readOnly = true)
    public List<Contact> list() {
        List<Contact> contacts = null;

        try {
            contacts = (List<Contact>) contactDao.findAll();

        } catch (Exception e) {
           e.getLocalizedMessage();
           throw e;
        }
        return contacts;
    }

    /**
     * save a new contact
     * @param contact Object
     * @return contact
     */
    @Override
    @Transactional
    public Contact save(Contact contact) {
        Contact cntSave = null;

        try {
            cntSave = contactDao.save(contact);

        } catch (Exception e) {
            e.getLocalizedMessage();
            throw e;
        }
        return cntSave;
    }

    /**
     * Update a contact
     * @param id Long
     * @param contact Object
     * @return contact
     */
    @Override
    @Transactional
    public Contact update(Long id, Contact contact) {
        Contact cntUpdate = null;

        try {
            contact.setId(id);
            cntUpdate = contactDao.save(contact);

        } catch (Exception e) {
            e.getLocalizedMessage();
            throw e;
        }
        return cntUpdate;
    }

    /**
     * Update fullName of a contact
     * @param id Long
     * @param contact Object
     */
    @Transactional
    public void updateFullName(Long id, Contact contact) {

        try {
            contactDao.updateFullName( id, contact.getFullName());

        } catch (Exception e) {
            e.getLocalizedMessage();
            throw e;
        }
    }

    /**
     * Update phone of a contact
     * @param id Long
     * @param contact Object
     */
    @Transactional
    public void updatePhone(Long id, Contact contact) {

        try {
            contactDao.updatePhone( id, contact.getPhone());

        } catch (Exception e) {
            e.getLocalizedMessage();
            throw e;
        }
    }

    /**
     * Update email of a contact
     * @param id Long
     * @param contact Object
     */
    @Transactional
    public void updateEmail(Long id, Contact contact) {

        try {
            contactDao.updateEmail( id, contact.getEmail());

        } catch (Exception e) {
            e.getLocalizedMessage();
            throw e;
        }
    }

    /**
     * Update dateOfBirth of a contact
     * @param id Long
     * @param contact Object
     */
    @Transactional
    public void updateDob(Long id, Contact contact) {

        try {
            contactDao.updateDob( id, contact.getDateOfBirth());

        } catch (Exception e) {
            e.getLocalizedMessage();
            throw e;
        }
    }

    /**
     * UpdateAt of a contact
     * @param id Long
     * @param contact Object
     */
    @Transactional
    public void updateAt( Long id, Contact contact) {

        try {
            contactDao.updateAt( id, contact.getUpdateAt());

        } catch (Exception e) {
            e.getLocalizedMessage();
            throw e;
        }
    }

    /**
     * DeleteAt of a contact
     * @param id Long
     * @param contact Object
     */
    @Transactional
    public void deleteAt(Long id, Contact contact) {

        try {
            contactDao.deleteAt( id, contact.getDeleteAt());

        } catch (Exception e) {
            e.getLocalizedMessage();
            throw e;
        }
    }

    /**
     * delete a contact
     * @param contact Object
     */
    @Override
    @Transactional
    public void delete(Contact contact) {

        try {
            contactDao.delete(contact);

        } catch (Exception e) {
            e.getLocalizedMessage();
            throw e;
        }
    }

    /**
     * Find one contact
     * @param contact Object
     * @return contact
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Contact> findContact(Contact contact) {
        Optional<Contact> cntFound = Optional.empty();

        try {
            cntFound = contactDao.findById(contact.getId());

        } catch (Exception e) {
            e.getLocalizedMessage();
            throw e;
        }
        return cntFound;
    }
}
