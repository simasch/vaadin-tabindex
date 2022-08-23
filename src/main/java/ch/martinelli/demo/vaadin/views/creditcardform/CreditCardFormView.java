package ch.martinelli.demo.vaadin.views.creditcardform;

import ch.martinelli.demo.vaadin.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Credit Card Form")
@Route(value = "credit-card-form", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class CreditCardFormView extends Div {

    private TextField cardNumber = new TextField("Credit card number");
    private TextField cardholderName = new TextField("Cardholder name");
    private PasswordField csc = new PasswordField("CSC");
    private DateTimePicker timestamp = new DateTimePicker("Timestamp");

    private Button cancel = new Button("Cancel");
    private Button submit = new Button("Submit");

    public CreditCardFormView() {
        addClassName("credit-card-form-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        cancel.addClickListener(e -> {
            Notification.show("Not implemented");
        });
        submit.addClickListener(e -> {
            Notification.show("Not implemented");
        });
    }

    private Component createTitle() {
        return new H3("Credit Card");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();

        cardNumber.focus();
        cardNumber.setTabIndex(1);
        timestamp.setTabIndex(2);
        cardholderName.setTabIndex(3);
        csc.setTabIndex(4);

        cardNumber.setPlaceholder("1234 5678 9123 4567");
        cardNumber.setPattern("[\\d ]*");
        cardNumber.setPreventInvalidInput(true);
        cardNumber.setRequired(true);
        cardNumber.setErrorMessage("Please enter a valid credit card number");

        formLayout.add(cardNumber, timestamp, cardholderName, csc);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(submit);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

}
