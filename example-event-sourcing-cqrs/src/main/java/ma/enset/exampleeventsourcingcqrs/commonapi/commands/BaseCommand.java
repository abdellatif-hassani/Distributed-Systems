package ma.enset.exampleeventsourcingcqrs.commonapi.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand<T> {
    @TargetAggregateIdentifier
    @Getter public T id;

    public BaseCommand(T id) {
        this.id = id;
    }


}
