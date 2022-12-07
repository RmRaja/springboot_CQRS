package com.userws.aggregates;

import com.userws.commands.CreateUserCommand;
import com.userws.events.UserCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UserAggregate {

    @AggregateIdentifier
    private Long id;
    private String name;
    private String email;
    private String password;

    public UserAggregate() {
    }

    @CommandHandler
    public UserAggregate(CreateUserCommand command) {
        if (command.getName().isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent();
        BeanUtils.copyProperties(command, userCreatedEvent);
        AggregateLifecycle.apply(userCreatedEvent); // this will dispatch an event to the event handler method inside the aggregate class
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent event) {
        System.out.println("User created event received");
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.password = event.getPassword();
    }
}
