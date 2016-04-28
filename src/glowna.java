import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by iwona on 27.04.16.
 */

@Controller
@EnableAutoConfiguration

public class glowna {

    ArrayList<uczniowie> lista = new ArrayList<uczniowie>();
    final static Logger logger = Logger.getLogger(glowna.class);


    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(glowna.class, args);
    }

    @RequestMapping(value = "/uczniowie", method = RequestMethod.GET)
    @ResponseBody
    public Object[] wszyscyUczniowie()
    {
        logger.info("pokaz wszystkich  uczniow");
        return lista.toArray();
    }

    @RequestMapping(value = "/uczen/dodaj/{imie}&{nazwisko}", method = RequestMethod.PUT)
    @ResponseBody
    public Object[] dodajUcznia(@PathVariable String imie, @PathVariable String nazwisko)
    {
        logger.info("dodawanie ucznia: "+imie+" "+nazwisko);
        lista.add(new uczniowie(imie, nazwisko, lista.size()+1));
        return lista.toArray();
    }

    @RequestMapping(value = "/uczen/usun/{numer}", method = RequestMethod.DELETE)
    @ResponseBody
    public void usunUcznia(@PathVariable int numer)
    {
        logger.info("usuwanie ucznia o nr: "+numer);
        lista.remove(numer-1);
    }

    @RequestMapping(value = "/uczen/dodajocene/{numer}&{ocena}", method = RequestMethod.PUT)
    @ResponseBody
    public boolean sdodajOcene(@PathVariable int numer, @PathVariable int ocena) {
        return lista.get(numer - 1).ustawOcene(ocena);
    }

    @RequestMapping(value = "/uczen/pokaz/{number}", method = RequestMethod.GET)
    @ResponseBody
    public uczniowie pokazUcznia(@PathVariable int number)
    {
        return lista.get(number - 1);
    }


}
