package in.pritha.convertor;

import java.time.LocalDate;

import javax.persistence.AttributeConverter;

//@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, String> {

	@Override
	public String convertToDatabaseColumn(LocalDate locDate) {
		return locDate == null ? null : locDate.toString();
	}

	@Override
	public LocalDate convertToEntityAttribute(String sqlDate) {
		return sqlDate == null ? null : LocalDate.parse(sqlDate);
	}

}
