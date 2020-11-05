package modelo;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 
 * @author laura
 * clase utilizada para adaptar el formato del campo fecha que es localdate a string
 *
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
	    public LocalDate unmarshal(String v) throws Exception {
	        return LocalDate.parse(v);
	    }

	    public String marshal(LocalDate v) throws Exception {
	        return v.toString();
	    }

}
