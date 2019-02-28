package ru.vavtech.springjavafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.vavtech.springjavafx.ui.MainController;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ControllerConfiguration {

    @Bean(name = "mainView")
    public ViewHolder getMainView() {
        return loadView();
    }

    @Bean
    public MainController getMainController() {
        return (MainController) getMainView().getController();
    }


    protected ViewHolder loadView() {
        InputStream fxmlStream = null;
        try{
            fxmlStream = getClass().getClassLoader().getResourceAsStream("fxml/main.fxml");
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return new ViewHolder(loader.getRoot(), loader.getController());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Data
    @AllArgsConstructor
    public class ViewHolder {
        private Parent view;
        private Object controller;
    }
}
