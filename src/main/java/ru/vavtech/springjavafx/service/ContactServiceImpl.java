package ru.vavtech.springjavafx.service;

import org.springframework.stereotype.Service;
import ru.vavtech.springjavafx.model.Contact;
import ru.vavtech.springjavafx.repository.ContactRepositiry;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    private final ContactRepositiry repositiry;

    public ContactServiceImpl(ContactRepositiry repositiry) {
        this.repositiry = repositiry;
    }

    @Override
    public Contact save(Contact contact) {
        return repositiry.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return repositiry.findAll();
    }

    @PostConstruct
    public void init(){
        save(new Contact("Иванов Иван Иванович", "+79001231212", "ivanov@ya.ru"));
        save(new Contact("Петров Иван Иванович", "+79001231213", "petrov@ya.ru"));
    }
}
