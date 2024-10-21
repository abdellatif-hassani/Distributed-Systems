package ma.enset.exampleeventsourcingcqrs.commonapi.commands;

public class CreateAccountCommand extends BaseCommand<String> {
    public final double accountBalance;
    private String currency;

    public CreateAccountCommand(String id, double accountBalance, String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }

}
