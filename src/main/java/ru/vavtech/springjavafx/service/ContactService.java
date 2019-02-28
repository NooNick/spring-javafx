package ru.vavtech.springjavafx.service;

import ru.vavtech.springjavafx.model.Contact;

import java.util.List;

public interface ContactService {

    Contact save(Contact contact);

    List<Contact> findAll();
}
