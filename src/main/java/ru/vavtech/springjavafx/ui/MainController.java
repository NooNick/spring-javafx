package ru.vavtech.springjavafx.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import ru.vavtech.springjavafx.model.Contact;
import ru.vavtech.springjavafx.service.ContactService;

import javax.annotation.PostConstruct;
import java.util.List;

public class MainController {

    @Autowired
    private ContactService contactService;

    @FXML
    private TableView<Contact> table;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtEmail;

    private ObservableList<Contact> data;

    @FXML
    public void initialize(){}

    @PostConstruct
    public void init(){
        List<Contact> contacts = contactService.findAll();
        data = FXCollections.observableArrayList(contacts);

        TableColumn<Contact, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Contact, String> nameColumn = new TableColumn<>("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Contact, String> phoneColumn = new TableColumn<>("Телефон");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Contact, String> emailColumn = new TableColumn<>("E-mail");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().setAll(idColumn, nameColumn, phoneColumn, emailColumn);

        table.setItems(data);
    }

    @FXML
    public void addContact() {
        String name = txtName.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();

        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(phone) || StringUtils.isEmpty(email)) {
            return;
        }

        Contact contact = new Contact(name, phone, email);
        contactService.save(contact);
        data.add(contact);

        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }



}
