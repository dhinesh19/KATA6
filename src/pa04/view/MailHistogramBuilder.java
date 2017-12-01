package pa04.view;

import pa04.model.Histogram;
import pa04.model.Mail;
import java.util.List;
import kata4.Attribute;

public class MailHistogramBuilder <T> {

    public MailHistogramBuilder(List<T> items) {
        this.items = items;
    }
    
    private final List <T> items;
    
    public <A>Histogram<A> build (Attribute <T,A> attribute){
           Histogram<A> histo = new Histogram<>();
           for (T item : items) {
               A value = attribute.get(item);
               histo.increment(value);}
    
    /*public static Histogram<String> build(List<Mail> mail){
        Histogram<String> histo = new Histogram<>();
        for (Mail mail1 : mail) {
            histo.increment(mail1.getDomain());
        }*/
        return histo;
    }
}
