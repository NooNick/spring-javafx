package ru.vavtech.springjavafx.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vavtech.springjavafx.model.Contact;

import java.util.List;

public interface ContactRepositiry extends CrudRepository<Contact, Long> {

    List<Contact> findAll();

}
