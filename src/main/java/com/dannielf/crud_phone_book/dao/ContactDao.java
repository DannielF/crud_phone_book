package com.dannielf.crud_phone_book.dao;

import com.dannielf.crud_phone_book.domain.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Data access object for Contact
 *
 * @version 1.0.0
 * @author Daniel Granados
 * @since 1.0.0
 */
public interface ContactDao extends CrudRepository<Contact, Long> {

    /**
     * Update fullName of the contact
     * @param id Long
     * @param fullName String
     */
    @Modifying
    @Query("update Contact cnt set cnt.fullName = :fullName where cnt.id = :id")
    public void updateFullName(
      @Param(value = "id") Long id,
      @Param(value = "fullName") String fullName
    );

    /**
     * Update phone of the contact
     * @param id Long
     * @param phone String
     */
    @Modifying
    @Query("update Contact  cnt set cnt.phone = :phone where cnt.id = :id")
    public void updatePhone(
      @Param(value = "id") Long id,
      @Param(value = "phone") String phone
    );

    /**
     * Update email of the contact
     * @param id Long
     * @param email String
     */
    @Modifying
    @Query("update Contact cnt set cnt.email = :email where cnt.id = :id")
    public void updateEmail(
      @Param(value = "id") Long id,
      @Param(value = "email") String email
    );

    /**
     * Update date of birth
     * @param id Long
     * @param dateOfBirth Date
     */
    @Modifying
    @Query("update Contact cnt set cnt.dateOfBirth = :dateOfBirth where cnt.id = :id")
    public void updateDob(
      @Param(value = "id") Long id,
     @Param(value = "dateOfBirth") Date dateOfBirth
    );

    /**
     * UpdateAt date
     * @param id Long
     * @param updateAt Date
     */
    @Modifying
    @Query("update Contact cnt set cnt.updateAt = :updateAt where cnt.id = :id")
    public void updateAt(
      @Param(value = "id") Long id,
      @Param(value = "updateAt") Date updateAt
    );

    /**
     * DeleteAt date
     * @param id Long
     * @param deleteAt Date
     */
    @Modifying
    @Query("update Contact cnt set cnt.deleteAt = :deleteAt where cnt.id = :id")
    public void deleteAt(
            @Param(value = "id") Long id,
            @Param(value = "deleteAt") Date deleteAt
    );
}
