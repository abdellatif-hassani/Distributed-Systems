package ma.enset.exampleeventsourcingcqrs.commonapi.commands;

public class CreditAccountCommand extends BaseCommand<String> {
    public final double debitAmount;
    private String currency;

    public CreditAccountCommand(String id, double debitAmount, String currency) {
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }
}
