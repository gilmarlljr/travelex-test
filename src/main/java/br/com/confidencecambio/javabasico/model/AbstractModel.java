package br.com.confidencecambio.javabasico.model;

import br.com.confidencecambio.javabasico.exception.ValitaionException;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValitaionException {
        if (Strings.isBlank(name)) {
            throw new ValitaionException("Nome nao poder ser nulo e nem estar vazio");
        }
        this.name = name.trim();
    }

    public String getNameUppercase() {
        return name.toUpperCase();
    }

    public String getFistName() {
        return name.split(" ")[0];
    }

    public String getLastName() {
        var names = new ArrayList<>(Arrays.asList(name.split(" ")));
        if (names.size() > 1) {
            var lastName = new StringBuilder();
            names.remove(0);
            names.forEach(s -> lastName.append(s).append(" "));
            return lastName.toString().trim();
        } else {
            return name;
        }
    }

    public String getAbbreviatedName() {
        var names = new ArrayList<>(Arrays.asList(name.split(" ")));
        if (names.size() > 2) {
            var abbName = new StringBuilder(names.get(0));
            var lastName = names.get(names.size() - 1);
            names.remove(0);
            names.remove(names.size() - 1);
            names.forEach(s -> {
                if (!s.toLowerCase().matches("d[aeo]"))
                    abbName.append(" ").append(abbreviate(s));
            });
            abbName.append(" ").append(lastName);
            return abbName.toString().trim();
        } else {
            return name;
        }
    }

    private String abbreviate(String string) {
        return string.charAt(0) + ".";
    }
}
