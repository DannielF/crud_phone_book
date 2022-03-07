package com.dannielf.crud_phone_book.service;

import com.dannielf.crud_phone_book.dao.ContactDao;
import com.dannielf.crud_phone_book.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IContactService{

    @Autowired
    private ContactDao contactDao;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> list() {
        List<Contact> contacts = null;

        try {
            contacts = (List<Contact>) contactDao.findAll();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            e.getLocalizedMessage();
        }
        return contacts;
    }

    @Override
    @Transactional
    public Contact save(Contact contact) {
        Contact cntSave = null;

        try {
            cntSave = contactDao.save(contact);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            e.getLocalizedMessage();
        }
        return cntSave;
    }

    @Override
    @Transactional
    public Contact update(Long id, Contact contact) {
        Contact cntUpdate = null;

        try {
            contact.setId(id);
            cntUpdate = contactDao.save(contact);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            e.getLocalizedMessage();
        }
        return cntUpdate;
    }

    @Transactional
    public void updateFullName(Long id, Contact contact) {

        try {
            contactDao.updateFullName( id, contact.getFullName());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            e.getLocalizedMessage();
        }
    }

    @Transactional
    public void updatePhone(Long id, Contact contact) {

        try {
            contactDao.updatePhone( id, contact.getPhone());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            e.getLocalizedMessage();
        }
    }

    @Transactional
    public void updateEmail(Long id, Contact contact) {

        try {
            contactDao.updateEmail( id, contact.getEmail());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            e.getLocalizedMessage();
        }
    }

    @Transactional
    public void updateDob(Long id, Contact contact) {

        try {
            contactDao.updateDob( id, contact.getDateOfBirth());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            e.getLocalizedMessage();
        }
    }

    @Transactional
    public void updateAt( Long id, Contact contact) {

        try {
            contactDao.updateAt( id, contact.getUpdateAt());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            e.getLocalizedMessage();
        }
    }

    @Transactional
    public void deleteAt(Long id, Contact contact) {

        try {
            contactDao.deleteAt( id, contact.getDeleteAt());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            e.getLocalizedMessage();
        }
    }

    @Override
    @Transactional
    public void delete(Contact contact) {

        try {
            contactDao.delete(contact);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            e.getLocalizedMessage();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contact> findContact(Contact contact) {
        Optional<Contact> cntFound = Optional.empty();

        try {
            cntFound = contactDao.findById(contact.getId());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            e.getLocalizedMessage();
        }
        return cntFound;
    }
}
