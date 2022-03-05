package com.dannielf.crud_phone_book.dao;

import com.dannielf.crud_phone_book.domain.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface ContactDao extends CrudRepository<Contact, Long> {

    @Modifying
    @Query("update Contact cnt set cnt.fullName = :fullName where cnt.id = :id")
    public void updateFullName(
      @Param(value = "id") Long id,
      @Param(value = "fullName") String fullName
    );

    @Modifying
    @Query("update Contact  cnt set cnt.phone = :phone where cnt.id = :id")
    public void updatePhone(
      @Param(value = "id") Long id,
      @Param(value = "phone") String phone
    );

    @Modifying
    @Query("update Contact cnt set cnt.email = :email where cnt.id = :id")
    public void updateEmail(
      @Param(value = "id") Long id,
      @Param(value = "email") String email
    );

    @Modifying
    @Query("update Contact cnt set cnt.dateOfBirth = :dateOfBirth where cnt.id = :id")
    public void updateDob(
      @Param(value = "id") Long id,
     @Param(value = "dateOfBirth") Date dateOfBirth
    );

    @Modifying
    @Query("update Contact cnt set cnt.updateAt = :updateAt where cnt.id = :id")
    public void updateAt(
      @Param(value = "id") Long id,
      @Param(value = "updateAt") Date updateAt
    );

    @Modifying
    @Query("update Contact cnt set cnt.deleteAt = :deleteAt where cnt.id = :id")
    public void deleteAt(
            @Param(value = "id") Long id,
            @Param(value = "deleteAt") Date deleteAt
    );

}
