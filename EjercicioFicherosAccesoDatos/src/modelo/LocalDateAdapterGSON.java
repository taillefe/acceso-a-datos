package modelo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalDateAdapterGSON extends TypeAdapter<LocalDate> {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
	
	@Override
	public LocalDate read(JsonReader jsonReader) throws IOException {
		
		return LocalDate.parse(jsonReader.nextString(), formatter);
	}

	@Override
	public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
		jsonWriter.value(localDate.format(formatter));
		
	}
	

}
