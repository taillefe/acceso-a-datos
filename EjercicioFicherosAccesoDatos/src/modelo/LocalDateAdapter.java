package modelo;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 
 * @author laura
 * clase utilizada para adaptar el formato del campo fecha que es localdate a string 
 * y de string a localdate en XML
 *
 */

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
	
		@Override
	    public LocalDate unmarshal(String v) throws Exception {
	        return LocalDate.parse(v);
	    }

	    @Override
	    public String marshal(LocalDate v) throws Exception {
	        return v.toString();
	    }

}
