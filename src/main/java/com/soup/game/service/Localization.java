package com.soup.game.service;

import com.soup.game.intf.Service;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class Localization {
    public static Localization lang =
        new Localization(Locale.forLanguageTag("en"));
    private ResourceBundle bundle;
    private Locale locale;

    public Localization(Locale locale) {
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        String baseFile = "i18n/lang";
        bundle = ResourceBundle.getBundle(baseFile, locale);
    }

    public String t(String key) {
        try {
            return bundle.getString(key);
        } catch (Exception e) {
            return key;
        }
    }

    public String t(String key, Object... args) {
        try {
            return MessageFormat.format(bundle.getString(key), args);
        } catch (Exception e) {
            return key;
        }
    }

    public Locale getLocale() {
        return locale;
    }
}
