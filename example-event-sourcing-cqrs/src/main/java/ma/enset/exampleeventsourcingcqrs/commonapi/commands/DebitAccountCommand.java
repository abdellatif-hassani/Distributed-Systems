package ma.enset.exampleeventsourcingcqrs.commonapi.commands;

public class DebitAccountCommand extends BaseCommand<String> {
    public final double debitAmount;
    private String currency;

    public DebitAccountCommand(String id, double debitAmount, String currency) {
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }
}
