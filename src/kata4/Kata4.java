package kata4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import pa04.model.Histogram;
import pa04.model.Mail;
import pa04.view.HistogramDisplay;
import pa04.view.MailHistogramBuilder;
import pa04.view.MailListReader;

public class Kata4 {
    public static void main(String[] args) throws IOException, Exception {
        Kata4 histo = new Kata4();
        histo.execute();
    }
    
    private String filename;
    private List<Mail> mailList;
    
    private Histogram<String> histogram;
    private static HistogramDisplay histoDisplay;
    private MailHistogramBuilder<Mail> builder;
    private Histogram<String> domains;
    private Histogram<Character> letters;
        
    private void execute() throws Exception{
        input();
        process();
        output();
    }
    
    private void input() throws IOException{
        filename = "/Users/DaniMangtani/NetBeansProjects/Kata6/emails.txt";
        mailList = MailListReader.read(filename);
        builder = new MailHistogramBuilder<Mail>(mailList);
        
    }
    
    private void process(){
        domains = builder.build(new Attribute<Mail, String>() {
        @Override
        public String get(Mail item) {
            return item.getMail().split("@")[1];
        }
    });
        
    letters = builder.build(new Attribute<Mail, Character>() {
        @Override
        public Character get(Mail item) {
            return item.getMail().charAt(0);
        }
    });
    }
    
    private void output(){
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay (letters,"Primer Caracter").execute();
        histoDisplay.execute();
    }

}
