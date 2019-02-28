package ru.vavtech.springjavafx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public abstract class AbstractJavaFxApp extends Application {

    private static String[] savedArgs;

    protected ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        context = SpringApplication.run(getClass(), savedArgs);
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        context.stop();
    }

    protected static void launchApp(Class<? extends AbstractJavaFxApp> appClass, String[] args){
        AbstractJavaFxApp.savedArgs = args;
        Application.launch(appClass, args);
    }
}
