package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Ilya", " Pribytkov", "22247", "Tomsk"));
        List<Person> persons = phones.find("Ilya");
        assertThat(persons.iterator().next().getSurname(), is("Pribytkov"));
    }
}
