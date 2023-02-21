package de.adv.rfsprojekt.ur;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Utils {
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.#################", new DecimalFormatSymbols(Locale.US));
}
