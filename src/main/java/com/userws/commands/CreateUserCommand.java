package com.userws.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateUserCommand {
    @TargetAggregateIdentifier
    private final Long id;

    private final String name;

    private final String email;

    private final String password;
}
